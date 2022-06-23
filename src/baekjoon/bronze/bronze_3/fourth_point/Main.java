package baekjoon.bronze.bronze_3.fourth_point;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        List<Integer> candidateX = new ArrayList<>();
        List<Integer> candidateY = new ArrayList<>();

        candidateX.add((x));
        candidateY.add((y));

        for (int i = 0 ; i < 2 ; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if (candidateX.contains(x) && candidateY.contains(y)) {
                candidateX.remove(Integer.valueOf(x));
                candidateY.remove(Integer.valueOf(y));
            } else if (candidateX.contains(x)) {
                candidateX.remove(Integer.valueOf(x));
                candidateY.add(y);
            } else if (candidateY.contains(y)) {
                candidateY.remove(Integer.valueOf(y));
                candidateX.add(x);
            } else  {
                candidateX.add(x);
                candidateY.add(y);
            }
        }

        bw.write(candidateX.get(0) + " " + candidateY.get(0));
        bw.flush();
        bw.close();
    }
}
