package tag11;

public class Tag11 {
    public static int[][] input = new int[][]{{1, 5, 5, 3, 4, 2, 1, 2, 8, 8}, {5, 2, 5, 5, 3, 8, 4, 8, 8, 2}, {1, 2, 2, 4, 3, 1, 5, 7, 3, 2}, {4, 2, 5, 8, 2, 4, 2, 2, 7, 4}, {1, 6, 5, 8, 5, 6, 4, 2, 1, 6}, {6, 8, 7, 2, 6, 5, 1, 1, 8, 2}, {5, 7, 7, 5, 5, 5, 2, 2, 3, 8}, {5, 6, 2, 2, 5, 4, 5, 1, 7, 2}, {8, 7, 6, 6, 6, 7, 2, 3, 1, 8}, {2, 1, 7, 8, 3, 7, 4, 8, 3, 5}};
    static long flashCounter = 0;

    // part 1 und part 2 separat laufen lassen, weil sich durch die 100 steps
    // von part 1 das Ergebnis von part 2 verfälscht.
    // oder man addiert 100 auf das Ergebnis von part 2 ;)
    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        for (int step = 0; step < 100 ; step++) {
            passStep();
        }
        System.out.println(flashCounter);
    }

    public static void part2() {
        int step = 0;
        while(!allZeros(input)){
            passStep();
            step++;
        }
        System.out.println(step + 100);
    }

    private static void passStep() {
        for (int row = 0; row < Tag11.input.length; row++) {
            for (int col = 0; col < Tag11.input[0].length; col++) {
                Tag11.input[row][col]++;
            }
        }
        checkForTens(Tag11.input);
    }

    private static void checkForTens(int[][] octopuses) {
        boolean flash = false;
        for (int row = 0; row < octopuses.length; row++) {
            for (int col = 0; col < octopuses[0].length; col++) {
                if (octopuses[row][col] >= 10) {
                    octopuses[row][col] = 0;
                    flashCounter++;
                    flash = true;
                    incrementAllNeighbours(octopuses, row, col);
                }
            }
        }
        if (flash) {
            checkForTens(octopuses);
        }
    }

    private static void incrementAllNeighbours(int[][] octopuses, int row, int col) {
        int[] delta = new int[]{-1, 0, 1};
        for (int i = 0; i < delta.length; i++) {
            for (int j = 0; j < delta.length; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (allowedToFlash(octopuses, row + delta[i], col + delta[j])) {
                    octopuses[row + delta[i]][col + delta[j]]++;
                }
            }
        }
    }

    private static boolean allowedToFlash(int[][] octopuses, int row, int col) {
        return (row >= 0 && col >= 0 && row < octopuses.length && col < octopuses[0].length && octopuses[row][col] != 0);
    }

    public static boolean allZeros(int[][] octopuses){
        for (int[] octopus : octopuses) {
            for (int col = 0; col < octopuses[0].length; col++) {
                if (octopus[col] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
