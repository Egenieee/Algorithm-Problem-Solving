package backjoon.sugar_delivery;

import java.io.*;

public class Main {
    private static final int FIVE = 5;
    private static final int THREE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sugarWeight = Integer.parseInt(br.readLine());

        int sugarCount = getSugarCount(sugarWeight);

        bw.write(String.valueOf(sugarCount));
        bw.flush();
        bw.close();
    }

    private static int getSugarCount(int sugarWeight) {
        int remain;

        remain = sugarWeight % FIVE;

        if (remain == 0) {
            return sugarWeight / FIVE;
        } else {
            return getThreeSugarCount(sugarWeight);
        }
    }

    private static int getThreeSugarCount(int sugarWeight) {
        int quotient;
        int remain;

        for (int i = 0 ; i < sugarWeight / FIVE + 1 ; i++) {
            quotient = (sugarWeight / FIVE) - i;
            remain = sugarWeight - (FIVE * quotient);

            if (remain % THREE == 0) {
                return quotient + (remain/THREE);
            }
        }

        return -1;
    }
}
