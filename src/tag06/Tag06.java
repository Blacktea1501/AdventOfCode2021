package tag06;

import java.util.ArrayList;

public class Tag06 {

    public static double[] input = new double[]{5,3,2,2,1,1,4,1,5,5,1,3,1,5,1,2,1,4,1,2,1,2,1,4,2,4,1,5,1,3,5,4,3,3,1,4,1,3,4,4,1,5,4,3,3,2,5,1,1,3,1,4,3,2,2,3,1,3,1,3,1,5,3,5,1,3,1,4,2,1,4,1,5,5,5,2,4,2,1,4,1,3,5,5,1,4,1,1,4,2,2,1,3,1,1,1,1,3,4,1,4,1,1,1,4,4,4,1,3,1,3,4,1,4,1,2,2,2,5,4,1,3,1,2,1,4,1,4,5,2,4,5,4,1,2,1,4,2,2,2,1,3,5,2,5,1,1,4,5,4,3,2,4,1,5,2,2,5,1,4,1,5,1,3,5,1,2,1,1,1,5,4,4,5,1,1,1,4,1,3,3,5,5,1,5,2,1,1,3,1,1,3,2,3,4,4,1,5,5,3,2,1,1,1,4,3,1,3,3,1,1,2,2,1,2,2,2,1,1,5,1,2,2,5,2,4,1,1,2,4,1,2,3,4,1,2,1,2,4,2,1,1,5,3,1,4,4,4,1,5,2,3,4,4,1,5,1,2,2,4,1,1,2,1,1,1,1,5,1,3,3,1,1,1,1,4,1,2,2,5,1,2,1,3,4,1,3,4,3,3,1,1,5,5,5,2,4,3,1,4};
    public static ArrayList<Integer> timer = new ArrayList<>();

    public static void part1() {
        double counter = 300;
        ArrayList<Integer> fishes = new ArrayList<Integer>();
        for (double j : input) {
            fishes.add((int) j);
        }

        for (int day = 0; day < 256; day++) {
            double a = fishes.size();
            for (int i = 0; i < a; i++) {
                if(fishes.get(i) >0){
                fishes.set(i, fishes.get(i)-1);
                }else {
                    fishes.set(i, 6);
                    fishes.add(8);
                    counter++;
                }
            }
            System.out.println("Day = " + (day+1));
        }
        System.out.println(counter);
    }


    public static void main(String[] args) {
        part1();
    }

}
