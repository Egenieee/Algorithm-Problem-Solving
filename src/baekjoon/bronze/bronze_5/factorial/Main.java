package baekjoon.bronze.bronze_5.factorial;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(getFactorial(N)));
        bw.flush();
        bw.close();
    }

    // 3 -> 3! -> 3 * 2 * 1
    // 5 -> 5! -> 5 * 4 * 3 * 2 * 1

    private static int getFactorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        return n * getFactorial(n - 1);
    }

}
