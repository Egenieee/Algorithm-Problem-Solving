package programmers.level_2.game_map_shortest_distance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int n = maps.length; // 행의 크기
        int m = maps[0].length; // 열의 크기

        int[][] dist = new int[n][m];

        // 모든 칸 -1로 초기화 -> 방문 여부와 원점(0,0)으로부터의 거리 초기화 위함
        for (int[] oneLine : dist) {
            Arrays.fill(oneLine, -1);
        }

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0));
        dist[0][0] = 1;

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = currentPoint.x + dx[dir];
                int ny = currentPoint.y + dy[dir];

                // 현재 보고 있는 칸에서 상하좌우가 맵을 벗어났을 경우 pass
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                // 현재 보고 있는 칸에서 상하좌우를 이미 방문했거나, 벽이 있는 자리면 pass
                if (dist[nx][ny] >= 0 || maps[nx][ny] == 0) {
                    continue;
                }

                // 상하좌우 칸의 거리를 현재 보고 있는 칸보다 1크게 설정
                dist[nx][ny] = dist[currentPoint.x][currentPoint.y] + 1;

                queue.add(new Point(nx, ny));
            }
        }

        // 상대 팀 진영에 도달하지 못했다면 -1 반환
        if (dist[n - 1][m - 1] == -1) {
            return -1;
        }

        return dist[n - 1][m - 1];
    }
}
