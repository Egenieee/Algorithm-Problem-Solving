package baekjoon.silver.silver_1.block_numbering;

import java.io.*;
import java.util.*;

public class Main {
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

    private static List<Integer> getAreaCount(int[][] board, int n) {
        // 방문여부를 표시하기 위한 배열
        boolean[][] visited = new boolean[n][n];

        // 상하좌우 값을 계산하기 위한 배열
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int countOfArea = 0;
        int sizeOfArea = 0;

        List<Integer> sizeOfAreas = new ArrayList<>();

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 현재 보고 있는 땅이 물에 잠기었거나 이미 방문한 땅이면 bfs 시작 안함
                if (board[i][j] != 1 || visited[i][j]) {
                    continue;
                }

                // bfs 시작 -> 구역의 개수 하나 증가
                countOfArea++;

                // 현재 좌표 큐에 삽입
                queue.add(new Point(i, j));

                // 방문했다고 표시
                visited[i][j] = true;

                // 하나의 연결된 구역 찾는 반복문
                while (!queue.isEmpty()) {
                    // 큐에서 땅 하나 꺼내와서
                    Point curPoint = queue.poll();
                    sizeOfArea++;

                    // 하, 우, 상, 좌의 땅을 살펴본다.
                    for (int dir = 0; dir < 4; dir++) {
                        int nX = curPoint.getX() + dx[dir];
                        int nY = curPoint.getY() + dy[dir];

                        // nX와 nY가 땅 범위 밖으로 넘어갔다면 패스
                        if (nX < 0 || nX >= n || nY < 0 || nY >= n) {
                            continue;
                        }

                        // 방문하지 않았고, 물에 잠기지 않은 땅이라면 큐에 넣는다.
                        if (visited[nX][nY] || board[nX][nY] != 1) {
                            continue;
                        }

                        visited[nX][nY] = true;
                        queue.add(new Point(nX, nY));
                    }
                }
                sizeOfAreas.add(sizeOfArea);
                sizeOfArea = 0;
            }
        }

        Collections.sort(sizeOfAreas);

        return sizeOfAreas;
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
