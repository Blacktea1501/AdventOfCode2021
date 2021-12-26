package tag16;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.max;
import static java.util.Collections.min;

public class Tag16 {
    public static int versionSum = 0;
    private static int offset = 0;
    private static String input = null;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/home/artur/IdeaProjects/AdventOfCode/src/tag16/input.txt"));
        String line = "";
        while (sc.hasNext()) {
            line = sc.nextLine();
        }
        if (line.length() > 0) {
            line = hexToBin(line);
            System.out.println("Binary input: " + line);
            input = line;
            int _typeId = parseHeader();
            if (_typeId > -1) {
                System.out.println("Version sum: " + versionSum);
                BigInteger result = parsePacket(_typeId);
                System.out.println("Result: " + result);
            } else {
                System.out.println("Unknown TypeID");
            }

            //part1(line);
        } else {
            System.out.println("File is empty!");
        }

    }

    private static String hexToBin(String hex) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < hex.length(); i++) {
            int b = Byte.parseByte(String.valueOf(hex.charAt(i)), 16);
            res.append(String.format("%4s", Integer.toBinaryString(b)).replace(' ', '0'));
        }
        return res.toString();
    }

    private static int parseHeader() {
        if (offset + 6 >= input.length()) {
            offset = input.length();
            return -1;
        }
        int version = Integer.parseInt(input.substring(offset, offset + 3), 2);
        offset += 3;
        int typeID = Integer.parseInt(input.substring(offset, offset + 3), 2);
        offset += 3;
        versionSum += version;
        return typeID;
    }

    private static BigInteger parseLiteralValue() {
        String strBi = "";
        for (; offset < input.length(); offset += 5) {
            strBi += input.substring(offset + 1, offset + 5);
            if (input.charAt(offset) == '0') {
                offset += 5;
                break;
            }
        }
        BigInteger x = new BigInteger(strBi, 2);
        System.out.println("Literal Value: " + x);
        return x;
    }

    private static BigInteger parseOperatorValue(int typeId) {
        boolean lengthID = input.charAt(offset++) == '1';
        List<BigInteger> args = new ArrayList<>();
        if (lengthID) {
            //If the length type ID is 1, then the next 11 bits are a number that represents the number of sub-packets immediately contained by this packet.
            int numberOfPackets = Integer.parseInt(input.substring(offset, offset + 11), 2);
            offset += 11;
            for (int i = 0; i < numberOfPackets; i++) {
                int _typeId = parseHeader();
                if (_typeId > -1) {
                    args.add(parsePacket(_typeId));
                }
            }
        } else {
            //If the length type ID is 0, then the next 15 bits are a number that represents the total length in bits of the sub-packets contained by this packet.
            int totalLength = Integer.parseInt(input.substring(offset, offset + 15), 2);
            offset += 15;
            int startAt = offset;

            while (offset < startAt + totalLength) {
                int _typeId = parseHeader();
                if (_typeId > -1) {
                    args.add(parsePacket(_typeId));
                }
            }
        }

        return calculate(typeId, args);
    }

    private static BigInteger parsePacket(int typeId) {
        if (typeId == 4) {
            return parseLiteralValue();
        } else {
            return parseOperatorValue(typeId);
        }
    }

    private static BigInteger calculate(int typeId, List<BigInteger> args) {
        BigInteger res = null;
        switch (typeId) {
            case 0:
                res = BigInteger.ZERO;
                for (BigInteger arg : args) {
                    res = res.add(arg);
                }
                break;
            case 1:
                res = BigInteger.ONE;
                for (BigInteger arg : args) {
                    res = res.multiply(arg);
                }
                break;
            case 2:
                res = min(args);
                break;
            case 3:
                res = max(args);
                break;
            case 4:
                throw new IllegalArgumentException("Literal packet");
            case 5:
                if (args.get(0).compareTo(args.get(1)) == 1) {
                    res = BigInteger.ONE;
                } else {
                    res = BigInteger.ZERO;
                }
                break;
            case 6:
                if (args.get(0).compareTo(args.get(1)) == -1) {
                    res = BigInteger.ONE;
                } else {
                    res = BigInteger.ZERO;
                }
                break;
            case 7:
                if (args.get(0).compareTo(args.get(1)) == 0){
                    res = BigInteger.ONE;
                }else{
                    res = BigInteger.ZERO;
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown TypeID");
        }
        return res;
    }

}
