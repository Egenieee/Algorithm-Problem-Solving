package programmers.level_0.sum_of_consecutive_numbers;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(3, 0)));
    }

    public int[] solution(int num, int total) {
        int[] answer = {};

        for (int i = -1000; i <= 1000; i++) {
            if (isCorrectSum(total, i, num)) {
                answer = getAnswer(i, num);
            }
        }

        return answer;
    }

    private boolean isCorrectSum(int total, int start, int num) {
        int sum = 0;

        for (int i = 0; i < num; i++) {
            sum += start + i;
        }

        return sum == total;
    }


    private int[] getAnswer(int start, int num) {
        int[] answer = new int[num];

        for (int i = 0; i < num; i++) {
            answer[i] = start + i;
        }

        return answer;
    }
}
