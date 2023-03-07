package programmers.level_0.area_of_a_rectangle;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}}));
    }

    public int solution(int[][] dots) {
        return getLength(dots, 0) * getLength(dots, 1);
    }

    private int getLength(int[][] dots, int position) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            if (max < dots[i][position]) {
                max = dots[i][position];
            }

            if (min > dots[i][position]) {
                min = dots[i][position];
            }
        }

        return max - min;
    }
}
