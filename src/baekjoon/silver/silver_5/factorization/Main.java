package baekjoon.silver.silver_5.factorization;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while(N > 1) {
            int factorized = getFactorized(N);
            N /= factorized;

            if (factorized != -1) {
                bw.write(factorized + "\n");
            }
        }


        bw.flush();
        bw.close();
    }

    private static int getFactorized(int n) {
        for (int i = 2 ; i <= n ; i++) {
            if (n % i == 0) {
                return i;
            }
        }

        return -1;
    }
}
