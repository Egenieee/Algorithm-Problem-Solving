package programmers.level_1.making_hamburger;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3, 1, 2, 3, 1, 1, 2, 3, 1}));
    }

    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int eachIngredient : ingredient) {
            if (stack.isEmpty()) {
                stack.push(eachIngredient);
                continue;
            }

            if (eachIngredient == 1) {
                if (canMakeHamburger(stack)) {
                    removeIngredient(stack);
                    count++;

                    continue;
                }
            }

            stack.push(eachIngredient);
        }

        return count;
    }

    private boolean canMakeHamburger(Stack<Integer> stack) {
        if (stack.size() < 3) {
            return false;
        }

        return stack.elementAt(stack.size() - 1) == 3 && stack.elementAt(stack.size() - 2) == 2 && stack.elementAt(stack.size() - 3) == 1;
    }

    private void removeIngredient(Stack<Integer> stack) {
        for (int i = 0; i < 3; i++) {
            stack.pop();
        }
    }
}
