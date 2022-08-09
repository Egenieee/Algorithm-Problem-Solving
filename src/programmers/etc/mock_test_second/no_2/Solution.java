package programmers.etc.mock_test_second.no_2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3, 1, 4}));
    }

    public int solution(int[] topping) {
        int answer = 0;

        for (int splitIdx = 1; splitIdx < topping.length; splitIdx++) {
            if (isFairDivision(splitIdx, topping)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isFairDivision(int splitIdx, int[] topping) {
        Map<Integer, Integer> toppingTypeOne = new HashMap<>();
        Map<Integer, Integer> toppingTypeTwo = new HashMap<>();

        for (int i = 0; i < splitIdx; i++) {
            toppingTypeOne.put(topping[i], toppingTypeOne.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = splitIdx; i < topping.length; i++) {
            toppingTypeTwo.put(topping[i], toppingTypeTwo.getOrDefault(topping[i], 0) + 1);
        }

        return toppingTypeOne.size() == toppingTypeTwo.size();
    }
}
