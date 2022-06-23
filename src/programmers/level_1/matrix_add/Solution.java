package programmers.level_1.matrix_add;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] answer = solution.solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {4, 5}});
        System.out.println(Arrays.deepToString(answer));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

//        System.out.println(Arrays.deepToString(arr1));
//        System.out.println(Arrays.deepToString(arr2));

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}
