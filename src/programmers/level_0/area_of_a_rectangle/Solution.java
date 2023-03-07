package programmers.level_0.area_of_a_rectangle;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}}));
    }

    public int solution(int[][] dots) {
        int xMax = getMax(dots, 0); // 두번째 인자가 0이면 x, 1이면 y
        int yMax = getMax(dots, 1);
        int xMin = getMin(dots, 0);
        int yMin = getMin(dots, 1);

        return (xMax - xMin) * (yMax - yMin);
    }

    private int getMax(int[][] dots, int position) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            if (max < dots[i][position]) {
                max = dots[i][position];
            }
        }

        return max;
    }

    private int getMin(int[][] dots, int position) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            if (min > dots[i][position]) {
                min = dots[i][position];
            }
        }

        return min;
    }
}
