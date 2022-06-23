package backjoon.bronze.bronze_1.divisor;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int countOfDivisor = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int minDivisor = Integer.MAX_VALUE;
        int maxDivisor = Integer.MIN_VALUE;

        for (int i = 0 ; i < countOfDivisor ; i++) {
            int divisor = Integer.parseInt(st.nextToken());

            if (minDivisor >= divisor) {
                minDivisor = divisor;
            }

            if (maxDivisor <= divisor) {
                maxDivisor = divisor;
            }
        }

        bw.write(String.valueOf(maxDivisor * minDivisor));
        bw.flush();
        bw.close();
    }
}
