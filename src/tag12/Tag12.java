package tag12;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Tag12 {

    private static boolean isSmall(String cave) {
        return Character.isLowerCase(cave.charAt(0));
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("/home/artur/IdeaProjects/AdventOfCode/src/tag12/input.txt"));
        ArrayList<String[]> graph = new ArrayList<>();
        while (s.hasNextLine()) {
            graph.add(s.nextLine().strip().split("-"));
        }
        System.out.println(Arrays.deepToString(graph.toArray()));
    }
    

}
