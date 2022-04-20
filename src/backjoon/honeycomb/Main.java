package backjoon.honeycomb;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int diff = 6;
        int target = Integer.parseInt(br.readLine());

        int dist = 2;

        int start = 2;
        int start_multiplier = 1;

        int end = 7;
        int end_multiplier = 2;

        if (target == 1) {
            bw.write(String.valueOf(1));
            bw.close();
            bw.close();
            return;
        }

        while (start > target || end < target) {
            start += start_multiplier * diff;
            end += end_multiplier * diff;

            start_multiplier++;
            end_multiplier++;

            dist++;
        }

        bw.write(String.valueOf(dist));
        bw.flush();
        bw.close();

    }
}
