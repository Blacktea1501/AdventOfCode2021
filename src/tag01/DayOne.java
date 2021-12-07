package tag01;


import java.util.ArrayList;

import static java.lang.Math.sqrt;


public class DayOne {

    public static Reader reader = new Reader("src/adventOfCode/numbers.txt");
    public static ArrayList<Double> numbers = new ArrayList<Double>(reader.getDoubles());

    public static void measurement(ArrayList<Double> num) {
        int counter = 0;
        for (int i = 0; i < num.size(); i++) {
            if (i == 0) {
                System.out.println(num.get(0) + " (N/A - no previous measurement)");
            } else if (num.size() - i <= 2) {
                System.out.println("decreased");
            } else if ((num.get(i) + num.get(i + 1) + num.get(i + 2)) > num.get(i - 1) + num.get(i) + num.get(i + 1)) {
                counter = counter + 1;
                System.out.println(num.get(i) + num.get(i + 1) + num.get(i + 2) + " increased " + counter + " times");
            } else if (num.get(i) + num.get(i + 1) + num.get(i + 2) == num.get(i - 1) + num.get(i) + num.get(i + 1)) {
                System.out.println(num.get(i) + num.get(i + 1) + num.get(i + 2) + " nothing changed");
            } else {
                System.out.println(num.get(i) + num.get(i + 1) + num.get(i + 2) + " decreased");
            }
        }
    }


    public static void main(String[] args) {
        //measurement(numbers);
        System.out.println((1+sqrt(5))/2);
    }

}
