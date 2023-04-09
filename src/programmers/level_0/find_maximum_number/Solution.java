package programmers.level_0.find_maximum_number;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 3, 8})));
    }

    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                answer[0] = array[i];
                answer[1] = i;
            }
        }

        return answer;
    }
}
