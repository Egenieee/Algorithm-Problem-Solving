package programmers.etc.mock_test_second.no_2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 1, 2, 1, 1, 3, 4, 2, 5}));
    }

    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> splitLeft = new LinkedHashMap<>();
        Map<Integer, Integer> splitRight = new LinkedHashMap<>();

        for (int num : topping) {
            splitRight.put(num, splitRight.getOrDefault(num, 0) + 1);
        }
        for (int num : topping) {
            splitLeft.put(num, splitLeft.getOrDefault(num, 0) + 1);
            splitRight.put(num, splitRight.getOrDefault(num, 0) - 1);
            if (splitRight.get(num) == 0) {
                splitRight.remove(num);
            }

            if (splitLeft.size() == splitRight.size()) {
                answer++;
            }
        }

        return answer;
    }
}
