package programmers.level_1.painting_over;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 2, new int[]{2, 6}));
    }

    public int solution(int n, int m, int[] section) {
        int paintingCount = 0;

        boolean[] painted = getPaintWall(n, section);

        for (int part : section) {
            if (isRepainted(painted, m, part)) {
                paint(painted, m, part);
                paintingCount++;
            }
        }

        return paintingCount;
    }

    private void paint(boolean[] painted, int m, int part) {
        for (int i = 0; i < m; i++) {
            if (isValidRange(painted, part, i)) {
                painted[part - 1 + i] = true;
            }
        }
    }

    private boolean isRepainted(boolean[] painted, int m, int part) {
        for (int i = 0; i < m; i++) {
            if (isValidRange(painted, part, i)) { // 안칠해진 곳이 있으면 다시 칠해야한다고 반환
                if (!painted[part - 1 + i]) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValidRange(boolean[] painted, int part, int i) {
        return painted.length > part - 1 + i;
    }

    private boolean[] getPaintWall(int n, int[] section) {
        boolean[] painted = new boolean[n];

        Arrays.fill(painted, true);

        // 다시 칠해야 하는 구역은 false로 초기화
        for (int part : section) {
            painted[part - 1] = false;
        }

        return painted;
    }
}
