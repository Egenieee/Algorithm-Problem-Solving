package baekjoon.silver.silver_2.organic_cabbage;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int numberOfCabbage = Integer.parseInt(st.nextToken());

            int[][] field = new int[m][n];

            for (int cabbage = 0; cabbage < numberOfCabbage; cabbage++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                field[x][y] = 1;
            }

            bw.write(getEarthwormCount(field, m, n) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int getEarthwormCount(int[][] field, int m, int n) {
        int numberOfEarthworm = 0;

        boolean[][] visited = new boolean[m][n];

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                numberOfEarthworm++;

                queue.add(new Point(i, j));
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    Point currentPoint = queue.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nX = currentPoint.getX() + dx[dir];
                        int nY = currentPoint.getY() + dy[dir];

                        if (nX < 0 || nX >= m || nY < 0 || nY >= n) {
                            continue;
                        }

                        if (field[nX][nY] == 0 || visited[nX][nY]) {
                            continue;
                        }

                        queue.add(new Point(nX, nY));
                        visited[nX][nY] = true;
                    }
                }
            }
        }

        return numberOfEarthworm;
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
