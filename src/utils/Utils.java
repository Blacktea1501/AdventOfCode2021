package utils;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static int[][] stringListNumbersToArray(List<String> input){
      return input.stream().map(line -> line.chars().map(Character::getNumericValue).toArray()).toArray(size -> new int[size][0]);
    }

    public static boolean containsIn(String unique, String toCompare){
        int cnt = 0;
        for (int i = 0; i < unique.length(); i++) {
            String tmp = Character.toString(unique.charAt(i));
            if(toCompare.contains(tmp)){
                cnt++;
            }
        }
        return cnt == unique.length();
    }

    public static String buildString(String[] arr){
        StringBuilder builder= new StringBuilder();
        for (String s : arr){
            builder.append(s);
        }
        return builder.toString();
    }

    public static void printMatrixOfInt(int[][] matrix){
        for (int[] objects : matrix) {
            System.out.println(Arrays.toString(objects));
        }
    }
}
