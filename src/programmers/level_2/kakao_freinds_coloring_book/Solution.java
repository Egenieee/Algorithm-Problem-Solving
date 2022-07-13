package programmers.level_2.kakao_freinds_coloring_book;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final int DIRECTION_COUNT = 4;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = Integer.MIN_VALUE;

        int sizeOfOneArea;

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        boolean[][] visited = new boolean[m][n];

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                // BFS start !

                // save color
                int color = picture[i][j];

                sizeOfOneArea = 0;
                numberOfArea++;

                visited[i][j] = true;
                queue.add(new Point(i, j));

                while (!queue.isEmpty()) {
                    Point currentPoint = queue.poll();
                    sizeOfOneArea++;

                    for (int dir = 0; dir < DIRECTION_COUNT; dir++) {
                        int nX = currentPoint.getX() + dx[dir];
                        int nY = currentPoint.getY() + dy[dir];

                        // 하, 우, 상, 좌 칸의 인덱스 값을 확인해보고 그림 범위 밖으로 나가면 패스
                        if (nX < 0 || nX >= m || nY < 0 || nY >= n) {
                            continue;
                        }

                        // 하, 우, 상, 좌 칸의 값이 0이거나 같은 색이 아니거나 방문한 적이 있으면 패스
                        if (picture[nX][nY] == 0 || picture[nX][nY] != color || visited[nX][nY]) {
                            continue;
                        }

                        visited[nX][nY] = true;
                        queue.add(new Point(nX, nY));
                    }
                }

                // 구한 하나의 구역의 크기가 maxSizeOfOneArea 보다 크다면 갱신
                if (maxSizeOfOneArea < sizeOfOneArea) {
                    maxSizeOfOneArea = sizeOfOneArea;
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
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
