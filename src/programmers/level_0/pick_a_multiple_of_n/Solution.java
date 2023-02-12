package programmers.level_0.pick_a_multiple_of_n;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12})));
    }

    public int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist)
                .filter(number -> number % n == 0)
                .toArray();
    }
}
