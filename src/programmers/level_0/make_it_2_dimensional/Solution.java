package programmers.level_0.make_it_2_dimensional;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(new int[]{100, 95, 2, 4, 5, 6, 18, 33, 948}, 3)));
    }

    public int[][] solution(int[] num_list, int n) {
        int numberOfEachRow = num_list.length / n;

        int[][] answer = new int[numberOfEachRow][n];
        int index = 0;

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                answer[i][j] = num_list[index++];
            }
        }

        return answer;
    }
}
