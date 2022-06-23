package backjoon.bronze.bronze_1.snail_wanna_climb;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // (V-B) / (A-B) -> 나머지가 있다면 몫 + 1일, 없다면 그냥 몫만 답
        int quotient = (V - B) / (A - B);
        int remain = (V - B) % (A - B);

        if (remain == 0) {
            bw.write(String.valueOf(quotient));
        } else {
            bw.write(String.valueOf(quotient + 1));
        }

        bw.flush();
        bw.close();
    }
}
