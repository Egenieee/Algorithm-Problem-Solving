package baekjoon.gold.gold_5.red_green_color_blindness;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
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

        int N = Integer.parseInt(br.readLine());

        String[][] paint = new String[N][N];
        String[][] paintForRedGreenBlindness = new String[N][N];

        for (int i = 0; i < N; i++) {
            String oneLine = br.readLine();

            for (int j = 0; j < N; j++) {
                paint[i][j] = String.valueOf(oneLine.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (paint[i][j].equals("R") || paint[i][j].equals("G")) {
                    paintForRedGreenBlindness[i][j] = "N";
                } else {
                    paintForRedGreenBlindness[i][j] = "B";
                }
            }
        }

        bw.write(getCountOfPart(paint) + " " + getCountOfPart(paintForRedGreenBlindness));
        bw.flush();
        bw.close();
    }

    private static int getCountOfPart(String[][] paint) {
        int N = paint.length;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int countOfPart = 0;

        for (int i = 0; i < paint.length; i++) {
            for (int j = 0; j < paint.length; j++) {
                if (visited[i][j]) {
                    continue;
                }

                String color = paint[i][j];
                countOfPart++;

                visited[i][j] = true;

                queue.add(new Point(i, j));

                while (!queue.isEmpty()) {
                    Point currentPoint = queue.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nX = currentPoint.getX() + dx[dir];
                        int nY = currentPoint.getY() + dy[dir];

                        if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                            continue;
                        }

                        if (visited[nX][nY] || !paint[nX][nY].equals(color)) {
                            continue;
                        }

                        visited[nX][nY] = true;
                        queue.add(new Point(nX, nY));
                    }
                }
            }
        }

        return countOfPart;
    }
}
