package baekjoon.gold.gold_5.tomato;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] fields;
    static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int tomato;
        int countOfTomato = 0;
        int countOfYesterday = 0;

        fields = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato = Integer.parseInt(st.nextToken());
                if (tomato != -1) {
                    countOfTomato++;
                }
                fields[i][j] = tomato;
            }
        }

        while (true) {
            int count = oneDayPassed(fields, N, M);

            if (count == countOfTomato && days == 0) {
                bw.write(String.valueOf(0));
                break;
            }

            if (count == countOfYesterday) {
                bw.write(String.valueOf(-1));
                break;
            }

            days++;

            if (count == countOfTomato) {
                bw.write(String.valueOf(days));
                break;
            }

            countOfYesterday = count;
        }

        bw.flush();
        bw.close();

        // 날이 갔음에도 토마토의 개수가 변함이 없으면 -1 리턴하고, 날이 갔음에도 하루 처음 토마토 개수를 셌을 때와 똑같으면 0리턴

    }

    // 하루가 지났을 때 익은 토마토 개수를 반환하는 함수
    private static int oneDayPassed(int[][] fields, int N, int M) {
        int countOfTomato = 0;

        boolean[][] visited = new boolean[N][M];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (fields[i][j] != 1 || visited[i][j] || fields[i][j] == 0) {
                    continue;
                }

                countOfTomato++;

                visited[i][j] = true;

                // 상하좌우 한번만 보고 바꾼다. -> 하루가 지나면 근접한 토마토만 익으므로,,
                for (int dir = 0; dir < 4; dir++) {
                    int nX = i + dx[dir];
                    int nY = j + dy[dir];

                    if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                        continue;
                    }

                    if (fields[nX][nY] == 0) { // 안익은 토마토가 근접해 있을 경우 익게한다.
                        countOfTomato++;
                        fields[nX][nY] = 1;
                        visited[nX][nY] = true;
                    }
                }
            }
        }

        return countOfTomato;
    }
}
