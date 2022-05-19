package backjoon.fibonacci;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(getFibonacci(N)));
        bw.flush();
        bw.close();
    }

    private static int getFibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

}
