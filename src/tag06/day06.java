package tag06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day06 {
    public static double[] input = new double[]{5,3,2,2,1,1,4,1,5,5,1,3,1,5,1,2,1,4,1,2,1,2,1,4,2,4,1,5,1,3,5,4,3,3,1,4,1,3,4,4,1,5,4,3,3,2,5,1,1,3,1,4,3,2,2,3,1,3,1,3,1,5,3,5,1,3,1,4,2,1,4,1,5,5,5,2,4,2,1,4,1,3,5,5,1,4,1,1,4,2,2,1,3,1,1,1,1,3,4,1,4,1,1,1,4,4,4,1,3,1,3,4,1,4,1,2,2,2,5,4,1,3,1,2,1,4,1,4,5,2,4,5,4,1,2,1,4,2,2,2,1,3,5,2,5,1,1,4,5,4,3,2,4,1,5,2,2,5,1,4,1,5,1,3,5,1,2,1,1,1,5,4,4,5,1,1,1,4,1,3,3,5,5,1,5,2,1,1,3,1,1,3,2,3,4,4,1,5,5,3,2,1,1,1,4,3,1,3,3,1,1,2,2,1,2,2,2,1,1,5,1,2,2,5,2,4,1,1,2,4,1,2,3,4,1,2,1,2,4,2,1,1,5,3,1,4,4,4,1,5,2,3,4,4,1,5,1,2,2,4,1,1,2,1,1,1,1,5,1,3,3,1,1,1,1,4,1,2,2,5,1,2,1,3,4,1,3,4,3,3,1,1,5,5,5,2,4,3,1,4};
    public static List<Integer> state = new ArrayList<>();
    public static void solve(){
        for (double j : input) {
            state.add((int) j);
        }
        System.out.println(countLanternFish(state, 256));
    }


    public static long countLanternFish(List<Integer> state, int days) {
        long[] fish = new long[9];
        state.forEach(i -> fish[i]++);

        for (int day = 0; day < days; day++) {
            var newFish = fish[0];
            System.arraycopy(fish, 1, fish, 0, fish.length - 1);
            fish[6] += newFish;
            fish[8] = newFish;
        }

        return Arrays.stream(fish).sum();
    }

    public static void main(String[] args) {
        solve();
    }
}
