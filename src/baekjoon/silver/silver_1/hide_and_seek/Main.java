package baekjoon.silver.silver_1.hide_and_seek;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        time[n] = 0;

        int[] dx = new int[]{-1, 1};

        int seconds;

        while (!queue.isEmpty()) {
            int currentX = queue.poll();

            // 좌, 우 움직여서 초 수 기록, 뒤늦게 기록하게 된다면 더 적은 초로 도달할 수 있는 지 기록한다.
            for (int dir = 0; dir < 2; dir++) {
                seconds = time[currentX];
                int nX = currentX + dx[dir];

                if (nX < 0 || nX >= 100001 || time[nX] <= seconds) {
                    continue;
                }

                time[nX] = ++seconds;
                queue.add(nX);
            }

            seconds = time[currentX];
            int move = currentX * 2;

            if (move >= 100001 || time[move] <= seconds) {
                continue;
            }

            time[move] = ++seconds;
            queue.add(move);
        }

        bw.write(String.valueOf(time[k]));
        bw.flush();
        bw.close();
    }
}
