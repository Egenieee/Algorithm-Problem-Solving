package baekjoon.silver.silver_1.block_numbering;

import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> getAreaCount(int[][] board, int n) {
        // 방문여부를 표시하기 위한 배열
        boolean[][] visited = new boolean[n][n];

        // 상하좌우 값을 계산하기 위한 배열
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int sizeOfArea;

        List<Integer> sizeOfAreas = new ArrayList<>();

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 현재 보고 있는 칸이 1이 아니거나, 이미 방문한 칸이면 bfs 시작 안함
                if (board[i][j] != 1 || visited[i][j]) {
                    continue;
                }

                sizeOfArea = 0;

                // 현재 좌표 큐에 삽입
                queue.add(new Point(i, j));

                // 방문했다고 표시
                visited[i][j] = true;

                // 하나의 연결된 구역 찾는 반복문
                while (!queue.isEmpty()) {
                    // 큐에서 칸의 좌표 하나 꺼내와서
                    Point curPoint = queue.poll();
                    sizeOfArea++;

                    // 하, 우, 상, 좌의 칸을 살펴본다.
                    for (int dir = 0; dir < 4; dir++) {
                        int nX = curPoint.getX() + dx[dir];
                        int nY = curPoint.getY() + dy[dir];

                        // nX와 nY가 보드 범위 밖으로 넘어갔다면 패스
                        if (nX < 0 || nX >= n || nY < 0 || nY >= n) {
                            continue;
                        }

                        // 방문하지 않았고, 1이 아닌 칸이라면
                        if (visited[nX][nY] || board[nX][nY] != 1) {
                            continue;
                        }

                        // 방문 표시를 하고, 큐에 넣는다.
                        visited[nX][nY] = true;
                        queue.add(new Point(nX, nY));
                    }
                }
                sizeOfAreas.add(sizeOfArea);
            }
        }

        Collections.sort(sizeOfAreas);

        return sizeOfAreas;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] apartment = new int[n][n];

        for (int i = 0; i < n; i++) {
            String oneLine = br.readLine();

            for (int j = 0; j < n; j++) {
                apartment[i][j] = oneLine.charAt(j) - '0';
            }
        }

        List<Integer> answers = getAreaCount(apartment, n);

        bw.write(answers.size() + "\n");

        for (int size : answers) {
            bw.write(size + "\n");
        }

        bw.flush();
        bw.close();
    }

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
}
