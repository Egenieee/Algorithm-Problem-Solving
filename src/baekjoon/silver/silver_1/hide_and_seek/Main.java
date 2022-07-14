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
        Arrays.fill(time, -1);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        time[n] = 0;

        int[] dx = new int[]{-1, 1};

        int seconds;

        while (!queue.isEmpty()) {
            int currentX = queue.poll();

            // 좌, 우 움직여서 초 수 기록
            for (int dir = 0; dir < 2; dir++) {
                seconds = time[currentX];
                int nX = currentX + dx[dir];

                // 이동 후 범위 밖을 벗어나거나 이미 기록된 자리면 패스
                if (nX < 0 || nX >= 100001 || time[nX] != -1) {
                    continue;
                }

                time[nX] = ++seconds;
                queue.add(nX);
            }

            // 순간이동하는 경우
            seconds = time[currentX];
            int move = currentX * 2;

            // 이동 후 범위 밖을 벗어나거나 이미 기록된 자리면 패스
            if (move >= 100001 || time[move] != -1) {
                continue;
            }

            time[move] = ++seconds;
            queue.add(move);

            // k번째 인덱스까지 초가 기록되면 반복문 종료
            if (time[k] != -1) {
                break;
            }
        }

//        for (int i = 0 ; i < 21 ; i++) {
//            System.out.print(time[i] + " ");
//        }
//
//        System.out.println();

        bw.write(String.valueOf(time[k]));
        bw.flush();
        bw.close();
    }
}
