package programmers.level_2.pair_to_remove;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("cvv"));
    }

    // ArrayList -> 정확도 통과, 효율성 통과x
    // String replace -> 정확도 통과, 효율성 통과x
    // Stack -> 정확도 통과, 효율성 통과

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int pointer = 0;

        while (pointer != s.length()) {
            if (stack.empty()) {
                stack.push(s.charAt(pointer));
            } else {
                if (stack.peek() == s.charAt(pointer)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(pointer));
                }
            }

            pointer++;
        }

        if (stack.empty()) {
            return 1;
        }

        return 0;
    }
}
