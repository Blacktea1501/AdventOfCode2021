package tag01;


import java.util.ArrayList;

public class Tag01 {

    public static Reader reader = new Reader("/home/artur/IdeaProjects/AdventOfCode/src/tag01/numbers.txt");
    public static ArrayList<Double> numbers = new ArrayList<>(reader.getDoubles());

    public static void part1(ArrayList<Double> num) {
        int counter = 0;
        for (int i = 1; i < num.size(); i++) {
                if (num.get(i) > num.get(i - 1)) {
                    counter++;
                }
            }
        System.out.println(counter);
        }

    public static void part2(ArrayList<Double> num) {
        int counter = 0;
        for (int i = 2; i < num.size() - 1; i++) {
            if ((num.get(i) + num.get(i - 1) + num.get(i - 2)) < (num.get(i - 1) + num.get(i) + num.get(i + 1))) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        part1(numbers);
        part2(numbers);
    }

}
