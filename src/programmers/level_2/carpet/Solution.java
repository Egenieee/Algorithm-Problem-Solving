package programmers.level_2.carpet;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(24, 24)));
    }
    public int[] solution(int brown, int yellow) {
        // yellow 로 안에 들어갈 작은 상자 먼저 만들자.
        int column = 1;
        int row = yellow / column;

        // 가로가 세로보다 크거나 같을 때 까지만 반복
        while (row >= column) {
            if (yellow % column == 0) {
                row = yellow / column;
            }

            if (isBigBoxSize(row, column, brown, yellow)) {
                return new int[]{row + 2, column + 2};
            }

            column++;
        }
        return new int[]{0, 0};
    }

    private boolean isBigBoxSize(int row, int column, int brown, int yellow) {
        return (row + 2) * (column + 2) == (brown + yellow);
    }
}
