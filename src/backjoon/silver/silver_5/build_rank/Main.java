package backjoon.silver.silver_5.build_rank;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] weights = new int[N];
        int[] heights = new int[N];

        List<String> ranks = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < N ; i++) {
            int rank = 0;
            for (int j = 0 ; j < N ; j++) {
                if((weights[i] < weights[j]) && (heights[i] < heights[j])) {
                    rank++;
                }
            }
            rank++;
            ranks.add(String.valueOf(rank));
        }

        bw.write(String.join(" ", ranks));
        bw.flush();
        bw.close();
    }
}
