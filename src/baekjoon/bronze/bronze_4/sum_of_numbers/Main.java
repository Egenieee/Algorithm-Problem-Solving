package baekjoon.bronze.bronze_4.sum_of_numbers;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int sum = 0;

        for (int i = 0 ; i < N ; i++) {
            sum += numbers.charAt(i) - '0';
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
