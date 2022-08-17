package programmers.etc.mock_test_third.no_2;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3, 1, 2, 3, 1, 1}));
    }

    public int solution(int[] ingredients) {
        int answer = 0;
        boolean[] isValidHamburger = new boolean[4];
        Stack<Integer> stack = new Stack<>();

        for (int ingredient : ingredients) {
            if (stack.isEmpty()) {
                stack.add(ingredient);
            } else if (stack.peek() == 1) {
                if (ingredient == 2) {
                    isValidHamburger[0] = true;
                    isValidHamburger[1] = true;
                } else {
                    Arrays.fill(isValidHamburger, false);
                }
                stack.add(ingredient);
            } else if (stack.peek() == 2) {
                if (ingredient == 3) {
                    isValidHamburger[2] = true;
                } else {
                    Arrays.fill(isValidHamburger, false);
                }
                stack.add(ingredient);
            } else if (stack.peek() == 3) {
                if (ingredient == 1) {
                    isValidHamburger[3] = true;
                    if (isValid(isValidHamburger)) {
                        stack.pop();
                        stack.pop();
                        stack.pop();
                        answer++;
                    } else {
                        Arrays.fill(isValidHamburger, false);
                        stack.add(ingredient);
                    }
                } else {
                    Arrays.fill(isValidHamburger, false);
                    stack.add(ingredient);
                }
                Arrays.fill(isValidHamburger, false);
            }
        }
        return answer;
    }

    private boolean isValid(boolean[] isValidHamburger) {
        for (boolean valid : isValidHamburger) {
            if (!valid) {
                return false;
            }
        }

        return true;
    }
}
