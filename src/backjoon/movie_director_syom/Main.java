package backjoon.movie_director_syom;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int num = 665;
        int currentTh = 0;

        while (currentTh != N) {
            num++;
            if (String.valueOf(num).contains("666")) {
                currentTh++;
            }
        }

        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();
    }
}
