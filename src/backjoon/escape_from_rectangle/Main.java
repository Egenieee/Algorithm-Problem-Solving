package backjoon.escape_from_rectangle;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int diffXAndW = Math.abs(x - w);
        int diffYAndH = Math.abs(y - h);

        int minDistance = Math.min(Math.min(diffXAndW, diffYAndH), Math.min(x, y));

        bw.write(String.valueOf(minDistance));
        bw.flush();
        bw.close();
    }
}
