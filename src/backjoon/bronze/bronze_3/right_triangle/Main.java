package backjoon.bronze.bronze_3.right_triangle;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int[] lines = getLines(st);

            if (isStop(lines)) {
                break;
            }

            Arrays.sort(lines);

            bw.write(isRightTriangle(lines) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int[] getLines(StringTokenizer st) {
        int[] lines = new int[3];

        for (int i = 0 ; i < lines.length ; i++) {
            lines[i] = Integer.parseInt(st.nextToken());
        }

        return lines;
    }

    private static boolean isStop(int[] lines) {
        return Arrays.stream(lines).allMatch(i -> i == 0);
    }

    private static String isRightTriangle(int[] lines) {
        double aSquare = Math.pow(lines[0], 2);
        double bSquare = Math.pow(lines[1], 2);
        double cSquare = Math.pow(lines[2], 2);

        if (Math.sqrt(cSquare) == Math.sqrt(aSquare + bSquare)) {
            return "right";
        }

        return "wrong";
    }
}
