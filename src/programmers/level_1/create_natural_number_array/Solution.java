package programmers.level_1.create_natural_number_array;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(1234567891010L)));
    }

    public int[] solution(long n) {
        String number = String.valueOf(n);

        int[] answer = new int[number.length()];
        int index = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            answer[index++] = number.charAt(i) - '0';
        }

        return answer;
    }
}
