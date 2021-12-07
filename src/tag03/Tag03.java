package tag03;


import java.util.ArrayList;
import java.util.Arrays;

public class Tag03 {

    public  static String[] bins = {"101001100010", "010100001011", "010010010101", "110100011010", "001100100001", "111111110110", "000000101100", "001111000011", "101100100111", "001101110000", "001010010111", "001001001110", "111010110111", "100010111010", "111100110001", "000001011100", "001001010100", "010011011001", "101111010110", "111111101110", "101100111011", "100011010000", "011000100111", "010000111011", "100000011111", "000001010110", "101010011000", "010110001001", "000001011000", "000010001001", "111011011000", "101000001000", "101000001110", "110100101101", "100100010000", "100000111010", "000001111000", "011111010111", "000101011000", "101100100000", "110001111001", "100011111110", "101001101001", "010110011010", "010010100011", "100111110001", "011001111010", "000001111111", "110110000001", "110010011011", "011100001110", "000011010110", "000001101100", "110111110010", "010101100011", "010011000100", "100000111101", "100111001001", "110011110110", "000000100010", "111100110010", "101111001100", "110001111111", "100111101101", "100111010100", "101010001100", "010110110110", "110111110100", "111011101001", "010101000101", "101011010101", "110000110001", "111001100000", "010110011000", "011010100101", "000101111111", "001010000110", "110001000000", "100000110100", "110110111000", "100110010111", "000010111111", "101010000010", "010010000110", "001111101011", "100100011110", "000100110010", "001111010100", "111011010110", "110011000111", "000000001111", "010000111001", "011111100111", "000001011001", "011110100011", "010111000010", "000101000101", "010000011000", "001100011100", "100010111001", "011010100100", "110100000000", "000101011100", "000010100010", "001001101111", "001000011000", "111001011100", "001101111001", "100000100110", "100100101001", "011011010000", "110111011111", "101001010110", "101111000001", "000101110010", "011101111000", "100011100111", "110101110110", "111101011111", "010100111001", "011001100010", "101110011100", "011100110110", "110000010001", "100001101100", "001011010110", "111101011010", "101011101111", "101010010000", "101010111101", "110011100010", "010010101011", "101110000110", "001010100010", "010001001111", "000011111000", "011110100110", "110010011101", "101001101101", "100010101110", "011000111000", "011010110101", "010000011111", "110100110100", "001111001010", "101001001000", "001000000100", "010001100011", "010100000000", "011100100010", "011000000110", "101011111111", "010111010100", "001111110111", "110011111100", "010110100011", "101101011111", "100000001000", "011110101101", "001101011010", "100100010101", "111110100111", "010101100110", "100010011010", "100000101111", "101111000011", "010001110001", "101011110001", "100101011011", "110001111110", "101111010101", "100011001010", "000010101100", "111011100011", "010101110101", "011000100000", "000110100011", "001101011110", "000100011010", "001001000000", "111101111110", "001011010101", "010100001001", "000110011100", "110111100010", "110011100100", "101100001110", "011000101010", "101110010100", "001110111101", "111001110101", "100011101110", "011101000011", "100010100011", "000110010110", "111010011111", "011001101111", "110101000010", "110011000110", "111110101000", "001111111101", "101000100000", "011010001110", "001110101100", "111110111101", "001001000111", "111010110010", "111001010001", "001110001001", "111011011001", "110011010000", "100110101000", "000000010101", "101011001001", "001111111001", "111011101000", "100000011110", "001000111101", "000001110011", "000001111001", "110110001000", "000100011000", "111000111110", "010000101001", "110010110011", "101011011101", "110010101101", "010001111010", "100010101010", "011000111101", "010101001000", "001000010110", "100000000101", "010111110011", "011101101001", "100010011001", "000111011011", "100000100001", "000000110001", "100110000101", "100100111001", "001110111010", "110001001111", "000001110100", "010111111001", "011010001010", "001111011110", "101110100101", "111001111000", "000000111110", "011111101010", "001010010001", "101000000000", "011000111001", "000100000000", "110010000101", "001011011100", "100001010111", "101001001010", "001100010110", "110110111100", "011100100011", "100110101001", "000110110011", "110000101001", "110010110110", "001101111100", "001010111110", "000100010110", "111011001011", "011001110011", "101111110011", "100000000000", "011000010100", "010101000001", "111011000100", "010111101011", "001010111011", "001100111001", "101010100011", "000100000010", "101010010011", "101111100000", "100101010010", "001101101000", "010101100010", "010010011100", "001001100001", "101110110101", "011111011010", "101011011010", "001011110100", "110110011101", "111110110100", "100011010100", "000101011101", "111011111100", "110101000100", "111100100111", "110010100000", "100001010001", "111010010111", "010100101111", "010101110000", "000110010011", "111010001100", "000100110110", "011011000101", "001110100011", "011101111100", "000110111011", "110100110010", "000110010101", "000000000110", "010110000011", "110001011111", "010010001110", "100101111100", "110100101000", "010101000111", "100101011100", "110011111011", "011010111101", "111100111110", "100101000001", "110100101111", "110111100110", "010000000100", "010111000111", "011110010011", "111000010011", "111111100110", "001100000011", "000011110010", "111110010000", "010100010011", "001111111111", "000011101000", "101001011100", "111111100011", "110011101000", "101110111001", "111010111101", "001011101001", "110101011001", "111111010110", "011111011101", "111110011100", "100001010100", "001000011101", "011010011111", "100001101000", "010101100000", "111001010100", "001000100011", "001011010100", "011011111110", "000111000110", "011110011000", "111011111010", "111000110011", "101100001101", "111000100011", "001001110011", "011111100110", "100010100000", "000000100001", "010111001001", "001111110101", "100010111101", "011111110000", "100100100011", "011000111100", "000100101000", "110000001010", "001000110010", "101110000101", "100111111110", "011011111101", "110010111010", "100011001110", "110101101110", "011110000111", "101110100001", "101010011111", "101100101100", "010000000111", "101101000011", "100010001011", "010100110111", "111011001110", "110001001110", "111111110010", "010111100111", "000000100101", "000101110101", "011001011000", "000011000110", "000111011001", "001100101001", "110100101011", "011111100000", "101110010111", "010101001011", "011110110101", "101100101010", "100011111100", "101010000101", "000110111000", "111000110110", "101101010101", "110011101010", "001100110110", "010010011110", "110101010101", "101100110100", "111000011111", "001110101101", "010111011111", "110000001111", "000101101011", "101100111100", "000100001110", "011011011111", "001101101101", "000111001111", "011001100100", "011110101111", "100110001100", "111100101111", "001100011011", "110011010101", "000011000100", "001111100011", "111000001011", "000001010011", "011001000110", "101110110010", "100100110000", "001101110010", "000101100111", "000100101101", "110000000100", "010110001011", "001111010111", "001010101100", "011010110001", "100111001110", "111011010100", "110000001100", "000001011101", "010010110000", "111101101000", "000100011110", "011110111010", "111110111011", "000101100011", "001010100111", "100000001001", "110001011101", "111101010101", "100010010000", "011010011101", "111100010111", "111100100010", "101111010100", "010001110010", "001000111111", "101110111110", "000010111110", "100001001000", "100101000101", "010011111000", "110100000011", "011000001100", "010100010000", "010011010101", "111110001100", "000011011111", "110110011010", "111001011000", "011101101111", "001110110100", "110001101110", "000100111010", "101000111001", "010110110100", "011101001101", "101110111111", "000011011000", "011100101001", "111110011110", "101001001111", "001100010100", "110101001010", "000111111010", "000111000101", "001011111101", "001110001000", "001001000100", "100001100100", "110100010111", "010101001110", "110110111010", "011111110001", "000100001001", "110001010100", "101011100110", "011111101111", "000001110110", "000101101100", "110100001001", "001000110111", "000101111100", "101111101010", "011001101010", "100010010100", "101000110011", "101100010010", "110111000011", "111101100111", "111110011101", "011111111110", "110111110111", "001001101101", "010010111001", "010101000010", "100110101010", "111000110101", "101101110111", "010000101100", "111111101000", "111101110100", "000110000100", "101001110001", "011011111111", "001010110011", "101000000110", "000001100101", "000111001110", "001010111001", "110111001100", "010101101111", "110101111110", "001010110110", "011000000000", "011110100100", "000111011111", "101100110000", "001010010101", "111101101111", "100000100100", "110010110000", "101011110100", "110100110001", "110010010100", "011100001011", "001010001101", "111110010110", "001101111011", "011011101011", "001101100100", "001000110101", "010111100000", "110111110110", "110110010001", "101010110100", "101000111010", "100010100001", "111101001001", "110100010101", "110110100010", "101000000001", "010001010101", "010101100111", "101100001001", "000000101011", "000000100110", "111110100000", "010111101000", "011000011010", "101011000110", "000101001001", "010110010100", "011001001101", "011000011111", "101111101101", "001001001010", "010011011110", "100101100111", "110111000000", "001010000011", "101101110110", "110000001110", "010101100101", "101111001111", "111111011100", "001001001001", "110000000011", "110101010100", "100110111010", "000010100110", "111101100011", "100001000111", "010101110011", "001100001101", "110111111101", "011010110111", "101000101101", "011111001010", "000111001000", "001110100001", "000100010001", "010010111101", "111010110101", "101111010000", "101011110011", "001111111100", "111101010110", "111111000101", "001101011001", "000110111100", "111001110100", "011001110100", "101101101010", "110101000111", "011111110101", "000111101001", "000100010111", "000001101101", "101011000011", "010011000111", "010111010011", "101011001000", "100011011011", "101000110110", "000100111111", "010011101101", "110111111000", "010010000100", "010011000011", "111010000000", "111011101011", "010000100101", "101101001111", "011101100111", "100110100010", "000110000011", "110100011011", "000110101011", "111000011000", "111001010000", "001100101100", "100010010011", "001111011010", "100000110000", "010010000010", "111111000000", "011110110110", "001101001000", "010110011111", "011000000010", "010010100111", "000110100111", "101010001010", "101010110101", "010111110111", "000011101110", "100010000100", "110011000010", "011000101111", "111010001111", "000011001101", "001000101100", "000000001110", "000111110010", "100000010010", "100001110010", "111001111100", "001001111000", "000100101011", "011011100000", "001011101011", "100001111111", "111001111101", "110100001110", "011011101001", "000110011111", "010011011100", "001000101011", "101110001110", "111010000011", "110000111110", "110000011011", "100100110111", "101000011111", "101000011101", "110110001010", "011010101101", "100111111001", "001000000000", "100010101000", "101011101010", "001110010100", "011110011110", "000111100011", "001011101010", "100111100011", "111000101110", "000100000110", "101101111110", "101001110010", "000111110100", "100011011000", "010110011101", "011000010110", "111100001001", "110111001110", "010000010111", "000000010110", "010110011110", "011001000111", "101001100111", "000100100010", "101111010010", "110010101010", "100011101011", "001100100101", "011000011001", "101100111010", "110110110111", "101001011001", "101011001010", "110011011101", "101010111000", "010100100001", "011111100011", "111000010110", "001000100001", "111110000010", "111110111110", "000101101000", "010011001000", "000001101001", "101010101110", "011001010000", "001101001001", "111001010010", "110111110000", "000100111001", "010101111111", "101100011001", "000111010110", "000110000001", "001001000010", "000101101001", "111011010010", "000000000011", "001011110001", "111100110000", "000111010011", "100110111110", "101010000000", "001011110111", "111101100000", "011010000000", "110111001010", "010100000101", "110110100111", "011000101001", "101001001001", "100001010010", "101110000011", "111011110010", "101001100110", "001000100010", "101111110010", "010101101100", "000101111101", "011110100000", "010010100000", "111100010001", "100110100110", "111000010111", "011011101101", "010000011010", "001000111110", "010000010011", "011010100010", "110010101000", "011110000001", "101100110101", "001001010000", "101011010110", "100111011011", "100001111010", "100001000001", "101001010011", "001000010100", "001011011000", "010010101110", "010011010111", "110010001010", "111101110110", "110101000001", "010100010110", "001001101000", "010011000000", "001100001001", "011111011001", "110110101001", "011001000101", "000110101100", "110010111101", "010011011011", "111000001010", "101110111010", "101100101110", "000000101010", "111100011011", "111100010100", "011110010100", "000011011110", "101101111101", "110101011100", "110011001100", "111011010000", "011100000001", "110100110111", "010110011011", "100010000001", "010110000101", "111111010000", "011010111110", "010011001111", "000011110001", "100000101100", "011000101110", "000110110111", "000011110110", "101111011100", "101101111010", "100110111001", "101010001111", "100001100001", "100111100010", "101110010101", "100000010100", "100100000001", "011000010101", "000011001100", "110101100110", "101011111110", "010001101001", "010101110111", "111001000110", "000101001101", "101101010111", "011000001111", "001100110100", "111010000101", "010111111011", "010110001101", "010011101011", "010110110000", "111000101000", "000110100100", "111100101011", "110000100110", "110111010100", "101001111111", "111000001110", "011100000000", "100000110001", "101010001101", "001000010010", "111110001110", "001001011010", "101110010010", "100001000110", "001101111111", "110110011110", "100100010001", "000001001011", "110001111010", "111101000110", "010110111001", "101010001011", "111011010111", "110100100110", "100111111101", "111110011001", "110111001101", "000011100111", "000010100011", "000101100001", "100011100100", "011100001001", "000100111000", "101100011000", "000101000100", "011000001000", "011011101110", "100110110101", "001111001111", "011000011110", "100001100110", "101110010001", "110000111001", "011100011111", "101001010000", "111010010011", "011011001100", "100111101110", "010001111110", "110110000101", "100111110011", "010010010110", "111110100100", "100000011100", "101101100001", "110000101011", "000111100000", "100000101011", "000010000000", "010110100100", "111010011001", "000101110100", "111111001011", "000111000010", "110000000101", "100111000010", "101101101001", "011000110110", "010000101110", "111100100110", "111001110001", "000001100111", "001110101010", "110000101101", "100111000111", "100101010111", "100101111010", "011001001010", "000110011010", "010111011000", "011010010100", "011101101011", "101010111011", "110001101001", "010010100010", "111000001000", "000100101111", "011110111011", "001010101110", "011101111101", "101010111110", "100001000010", "111011000011", "001001100000", "110111100111", "110000010111", "111111111011", "011000101101", "001111000010", "010010001100", "111010010101", "001001100111", "101100010000", "000101110110", "000100000111", "011000000111", "001001111010", "011011010011", "001011100101", "011010111100", "100010011011", "100101111101", "000110010111", "101000101110", "100000110110", "111011110011", "110110001011", "100111011010", "100100011000", "100000111011", "010100100110", "100011100000", "111001011111", "101011111100", "111011001000", "011110010101", "010011000110", "001110010110", "010010011010", "010011100111", "101001101100", "110100000111", "110001101111", "010100000111"};
    public static ArrayList<String> binaries = new ArrayList<>();



    public static void part1(){

        binaries.addAll(Arrays.asList(bins));


        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        for (int col = 0; col < binaries.get(0).length(); col++) {
            int ones = 0;
            int zeroes = 0;

            for (String binary : binaries) {
                if (binary.charAt(col) == '0') {
                    zeroes++;
                } else {
                    ones++;
                }
            }
            gamma.append(ones > zeroes ? "1" : "0");
            epsilon.append(ones < zeroes ? "1" : "0");

        }
        System.out.println("Gamma = " + gamma);
        System.out.println("Epsilon = " + epsilon);
        System.out.println(Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2));
    }

    public static void part2() {
        ArrayList<String> oxygen = new ArrayList<>(binaries);
        ArrayList<String> co2 = new ArrayList<>(binaries);

        int col = 0;
        while (oxygen.size() > 1) {
            int ones = 0;
            int zeroes = 0;
            for (String s : oxygen) {
                if (s.charAt(col) == '0')
                    zeroes++;
                else
                    ones++;
            }
            char max = (ones >= zeroes ? '1' : '0');
            for (int row = oxygen.size() - 1; row >= 0; row--) {
                if (oxygen.get(row).charAt(col) != max)
                    oxygen.remove(row);
            }
            col++;
        }

        col = 0;
        while (co2.size() > 1) {
            int ones = 0;
            int zeroes = 0;
            for (String s : co2) {
                if (s.charAt(col) == '0')
                    zeroes++;
                else
                    ones++;
            }
            char min = (zeroes <= ones ? '0' : '1');
            for (int row = co2.size() - 1; row >= 0; row--) {
                if (co2.get(row).charAt(col) != min)
                    co2.remove(row);
            }
            col++;
        }

        System.out.println(Integer.parseInt(oxygen.get(0), 2) * Integer.parseInt(co2.get(0), 2));
    }

    public static void main(String[] args) {
        part1();
        part2();
    }



}
