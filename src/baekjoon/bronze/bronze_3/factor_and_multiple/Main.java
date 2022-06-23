package baekjoon.bronze.bronze_3.factor_and_multiple;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            if (one == 0 && two == 0) {
                break;
            }

            bw.write(getFactorOrMultiple(one, two) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static String getFactorOrMultiple(int one, int two) {
        if (two % one == 0) {
            return "factor";
        } else if (one % two == 0) {
            return "multiple";
        }

        return "neither";
    }
}
