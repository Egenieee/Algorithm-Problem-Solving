package baekjoon.bronze.bronze_2.sangsu;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder stringBuilder = new StringBuilder(st.nextToken()).reverse();
        int A = Integer.parseInt(stringBuilder.toString());

        stringBuilder.setLength(0);

        stringBuilder.append(st.nextToken()).reverse();
        int B = Integer.parseInt(stringBuilder.toString());

        int sangSuAnswer = Math.max(A, B);

        bw.write(String.valueOf(sangSuAnswer));
        bw.flush();
        bw.close();
    }
}
