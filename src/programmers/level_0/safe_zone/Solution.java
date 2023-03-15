package programmers.level_0.safe_zone;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static class Point {
        private final int x;
        private final int y;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}}));
    }

    public int solution(int[][] board) {
        boolean[][] visited = new boolean[board.length][board.length];

        int[] dx = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 1 || visited[i][j]) {
                    continue;
                }

                queue.add(new Point(i, j));
                visited[i][j] = true;
                board[i][j] = -1;

                while (!queue.isEmpty()) {
                    Point currentPoint = queue.poll();

                    for (int dir = 0; dir < 8; dir++) {
                        int nX = currentPoint.getX() + dx[dir];
                        int nY = currentPoint.getY() + dy[dir];

                        if (nX < 0 || nX >= board.length || nY < 0 || nY >= board.length) {
                            continue;
                        }

                        if (visited[nX][nY] || board[nX][nY] == 1) {
                            continue;
                        }

                        board[nX][nY] = -1;
                        visited[nX][nY] = true;
                    }
                }
            }
        }

        return getSafeZoneCount(board);
    }

    private int getSafeZoneCount(int[][] board) {
        int countOfSafeZone = 0;

        for (int[] ints : board) {
            for (int j = 0; j < board.length; j++) {
                if (ints[j] == 0) {
                    countOfSafeZone++;
                }
            }
        }

        return countOfSafeZone;
    }
}
