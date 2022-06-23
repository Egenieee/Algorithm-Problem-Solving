package baekjoon.bronze.bronze_2.break_even_point;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String info = br.readLine();
        StringTokenizer st = new StringTokenizer(info);

        int fixedCost = Integer.parseInt(st.nextToken());
        int variableCost = Integer.parseInt(st.nextToken());
        int pricePerOne = Integer.parseInt(st.nextToken());

        // n * C > A + n * B 이식을 만족해야 함.

        int breakEvenPoint;

        if ( pricePerOne - variableCost <= 0 ) {
            breakEvenPoint = -1;
        } else {
            breakEvenPoint = fixedCost / (pricePerOne - variableCost) + 1;
        }

        bw.write(String.valueOf(breakEvenPoint));
        bw.flush();
        bw.close();
    }
}
