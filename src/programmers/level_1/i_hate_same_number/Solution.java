package programmers.level_one.i_hate_same_number;

import java.util.*;

// IDE 없이 풂

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1, 2, 2, 2, 3, 3, 1, 2, 2, 1, 1}));
    }
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();

        int prev = -1;
        boolean isFirstNumber = false;

        for (int num : arr) {
            if (prev != num) {
                isFirstNumber = true;
            }

            if (isFirstNumber) {
                answer.add(num);
                isFirstNumber = false;
            }

            prev = num;
        }

        return answer;
    }
}
