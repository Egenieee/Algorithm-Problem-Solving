package backjoon.find_a_fraction;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int first = getFirstNumber(input);
        int last = getLastNumber(input);

        bw.write(first + "/" + last);
        bw.flush();
        bw.close();
    }

    private static int getFirstNumber(int input) {
        int subNumber = 1;
        int numberPosition = input;

        while (numberPosition - subNumber >= 1) {
            numberPosition -= subNumber;
            subNumber++;
        }

        return numberPosition;
    }

    private static int getLastNumber(int input) {
        int subNumber = 1;
        int numberPosition = input;

        while (numberPosition - subNumber >= 1) {
            numberPosition -= subNumber;
            subNumber++;
        }

        return subNumber - (numberPosition - 1);
    }
}
