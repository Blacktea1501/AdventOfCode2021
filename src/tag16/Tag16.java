package tag16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Tag16 {

    public static void part1(){

    }

    public static void main(String[] args) throws FileNotFoundException {
       try{ var input = Files.lines(Path.of("/home/artur/IdeaProjects/AdventOfCode/src/tag16/input.txt"));
           System.out.println(input.toString());
       } catch (IOException e) {
           e.printStackTrace();
       }
    }


}
