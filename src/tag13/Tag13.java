package tag13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static utils.Utils.*;

public class Tag13 {
    public static List<Integer> xCoordinates = new ArrayList<>();
    public static List<Integer> yCoordinates = new ArrayList<>();
    public static List<String> foldInstruction = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(new File("/home/artur/IdeaProjects/AdventOfCode/src/tag13/input.txt"));
        while (sc.hasNext()) {
            String line = sc.next();
            String[] coordinates = line.split(",");
            if (coordinates.length == 2) {
                xCoordinates.add(Integer.parseInt(coordinates[0]));
                yCoordinates.add(Integer.parseInt(coordinates[1]));
            }
            if (containsIn("x=", line) || containsIn("y=", line)) {
                foldInstruction.add(line);
            }
        }
        int maxX = Collections.max(xCoordinates) + 1;
        int maxY = Collections.max(yCoordinates) + 1;

        // creating the paper
        int[][] paper = new int[maxY][maxX];
        for (int y = 0; y < maxY; y++) {
            Arrays.fill(paper[y], 0);
        }

        // creating the dots on the paper
        for (int i = 0; i < xCoordinates.size(); i++) {
            paper[yCoordinates.get(i)][xCoordinates.get(i)] = 1;
        }

        part1(paper);
        part2(paper);

    }

    private static void part1(int[][] paper) {
        System.out.println(countPoints(foldOnce(paper, foldInstruction.get(0))));
    }

    private static void part2(int[][] paper) {
        int[][] origami = foldAllTheWay(paper, foldInstruction);
        print(origami);
    }

    private static int[][] foldAllTheWay(int[][] paper, List<String> foldInstruction) {
        for (String s : foldInstruction) {
            paper = fold(paper, s);
        }
        return paper;
    }

    private static int[][] foldOnce(int[][] grid, String foldInstruction) {
        return fold(grid, foldInstruction);
    }

    private static int[][] fold(int[][] grid, String foldInstruction) {
        if (foldInstruction.contains("x=")) {
            return foldX(grid, Integer.parseInt(foldInstruction.split("x=")[1]));
        } else {
            return foldY(grid, Integer.parseInt(foldInstruction.split("y=")[1]));
        }
    }

    private static int[][] foldY(int[][] grid, int yFoldLine) {
        int[][] newGrid = new int[yFoldLine][];
        for (int y = 0; y < yFoldLine; y++) {
            newGrid[y] = new int[grid[y].length];
            System.arraycopy(grid[y], 0, newGrid[y], 0, grid[y].length);
        }

        for (int y = yFoldLine + 1; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                newGrid[2 * yFoldLine - y][x] |= grid[y][x];
            }
        }
        return newGrid;
    }


    private static int[][] foldX(int[][] grid, int xFoldLine) {
        int[][] newGrid = new int[grid.length][];

        for (int y = 0; y < grid.length; y++) {
            newGrid[y] = new int[xFoldLine];
            System.arraycopy(grid[y], 0, newGrid[y], 0, xFoldLine);

            for (int x = xFoldLine + 1; x < grid[y].length; x++) {
                //first time using bitwise operator
                newGrid[y][2 * xFoldLine - x] |= grid[y][x];
            }
        }
        return newGrid;
    }

    private static int countPoints(int[][] paper) {
        int cnt = 0;
        for (int[] ints : paper) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void print(int[][] origami) {
        char[][] newGrid = new char [origami.length][origami[0].length];
        for (int row = 0; row < origami.length; row++) {
            for (int col = 0; col < origami[row].length; col++) {
                if(origami[row][col] == 0){
                    newGrid[row][col] = ' ';
                }else{
                    newGrid[row][col] = '#';
                }
            }
        }
        for (int row = 0; row < origami.length; row++) {
            System.out.println(Arrays.toString(newGrid[row]));
        }
    }

}