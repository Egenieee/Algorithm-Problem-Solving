package baekjoon.bronze.bronze_1.find_a_fraction;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int subNumber = getSubNumber(input);

        boolean isOdd = checkNumber(subNumber);

        int first = getFirstNumber(input, isOdd);
        int last = getLastNumber(input, isOdd);

        bw.write(first + "/" + last);
        bw.flush();
        bw.close();
    }

    private static boolean checkNumber(int subNumber) {
        return subNumber % 2 == 1;
    }

    private static int getFirstNumber(int input, boolean isOdd) {
        if (isOdd) {
            return getOddFirstNumber(input);
        }
        return getEvenFirstNumber(input);
    }

    private static int getOddFirstNumber(int input) {
        int subNumber = getSubNumber(input);
        int numberPosition = getNumberPosition(input);

        return subNumber - (numberPosition - 1);
    }

    private static int getEvenFirstNumber(int input) {
        return getNumberPosition(input);
    }

    private static int getLastNumber(int input, boolean isOdd) {
        if (isOdd) {
            return getOddLastNumber(input);
        }
        return getEvenLastNumber(input);
    }

    private static int getOddLastNumber(int input) {
        return getNumberPosition(input);
    }

    private static int getEvenLastNumber(int input) {
        int subNumber = getSubNumber(input);
        int numberPosition = getNumberPosition(input);

        return subNumber - (numberPosition - 1);
    }

    private static int getNumberPosition(int input) {
        int subNumber = 1;
        int numberPosition = input;

        while (numberPosition - subNumber >= 1) {
            numberPosition -= subNumber;
            subNumber++;
        }

        return numberPosition;
    }

    private static int getSubNumber(int input) {
        int subNumber = 1;
        int numberPosition = input;

        while (numberPosition - subNumber >= 1) {
            numberPosition -= subNumber;
            subNumber++;
        }

        return subNumber;
    }
}
