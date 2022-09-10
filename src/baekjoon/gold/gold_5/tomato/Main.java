package baekjoon.gold.gold_5.tomato;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] fields;
    static int[][] days;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int tomato;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        fields = new int[N][M];
        days = new int[N][M];

        int day = 0;

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato = Integer.parseInt(st.nextToken());
                if (tomato == 1) { // 익은 토마토 위치 큐에 저장한다.
                    queue.add(new Point(i, j));
                }
                if (tomato == 0) { // 익지 않은 토마토는 -1로 일 수를 설정한다.
                    days[i][j] = -1;
                }
                fields[i][j] = tomato;
            }
        }

        while (!queue.isEmpty()) {
            // 큐에서 익은 토마토 하나 꺼낸다.
            Point point = queue.poll();

            // 익은 토마토의 상하좌우 위치를 구한다.
            for (int dir = 0; dir < 4; dir++) {
                int nX = point.getX() + dx[dir];
                int nY = point.getY() + dy[dir];

                // 토마토 상자 범위를 벗어나면 pass
                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                // 일 수가 이미 구해졌다면 pass
                if (days[nX][nY] >= 0) {
                    continue;
                }

                // 상하좌우의 토마토가 익는 데 걸리는 시간을 (큐에서 꺼낸 익은 토마토의 현재 일 수 + 1로) 설정한다.
                days[nX][nY] = days[point.getX()][point.getY()] + 1;
                // 그런 뒤에 큐에 넣어준다.
                queue.add(new Point(nX, nY));
            }
        }

        // 큐가 빌 때 까지 위의 과정을 반복한뒤, days 배열을 순회한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (days[i][j] == -1) { // 배열에 -1가 있다면 모든 토마토가 익지 않은 것이므로 -1를 반환한다.
                    bw.write(String.valueOf(-1));
                    break;
                }
                // days 배열의 최대 일 수를 구해서 리턴한다.
                day = Math.max(day, days[i][j]);
            }
        }

        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();


    }
}
