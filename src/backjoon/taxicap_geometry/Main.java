package backjoon.taxicap_geometry;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double radius = Double.parseDouble(br.readLine());

        // PI * R^2
        bw.write(String.format("%.6f", (Math.PI * radius * radius)) + "\n");
        // 2 * R^2
        bw.write(String.format("%.6f", (2 * radius * radius)));

        bw.flush();
        bw.close();
    }
}
