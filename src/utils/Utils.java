package utils;

import java.util.List;

public class Utils {

    public static int[][] stringListNumbersToArray(List<String> input){
      return input.stream().map(line -> line.chars().map(Character::getNumericValue).toArray()).toArray(size -> new int[size][0]);
    }
}
