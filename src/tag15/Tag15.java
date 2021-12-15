package tag15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static utils.Utils.stringListNumbersToArray;

public class Tag15 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/home/artur/IdeaProjects/AdventOfCode/src/tag15/input.txt"));
        ArrayList<String> input = new ArrayList<>();
        while (sc.hasNextLine()) {
            input.add(sc.nextLine());
        }
        int[][] risk = stringListNumbersToArray(input);
        int[][] minRisk = new int[risk.length * 5][risk[0].length * 5];
        for (int[] ints : minRisk) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        minRisk[0][0] = 0;

        boolean done = false;
        int[][] neighbors = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}};

        while (!done) {
            done = true;
            for (int row = 0; row < minRisk.length; row++) {
                for (int col = 0; col < minRisk[row].length; col++) {
                    int currentRisk = minRisk[row][col];
                    for (int[] neighbor : neighbors) {
                        int rr = row + neighbor[0];
                        int cc = col + neighbor[1];
                        if (rr >= 0 && rr < minRisk.length && cc >= 0 && cc < minRisk[row].length) {
                            if (minRisk[rr][cc] > currentRisk + calcRisk(rr, cc, risk)){
                                done = false;
                                minRisk[rr][cc] = currentRisk + calcRisk(rr, cc, risk);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Part 1: " +  minRisk[risk.length - 1][risk[0].length -1]);
        System.out.println("Part 2: " + minRisk[minRisk.length - 1][minRisk[0].length - 1]);
    }

    public static int calcRisk(int r, int c, int[][] risk) {
        if (r < risk.length && c < risk[r].length) return risk[r][c];
        int adjRisk = 0;
        if (c >= risk[0].length) adjRisk = calcRisk(r, c - risk[0].length, risk) + 1;
        if (r >= risk.length) adjRisk = calcRisk(r - risk.length, c, risk) + 1;
        adjRisk = adjRisk % 10;
        if (adjRisk == 0) adjRisk = 1;
        return adjRisk;
    }
}
