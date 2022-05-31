package programmers.parenthesis_conversion;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("()()())(())("));
    }

    public String solution(String p) {
        if (isRightParenthesis(p)) {
            return p;
        }

        return getConvertedParenthesis(p);
    }

    private boolean isRightParenthesis(String p) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < p.length() ; i++) {
            if (stack.empty()) {
                stack.push(p.charAt(i));
            } else {
                if (stack.peek() == '(' && p.charAt(i) == ')') {
                    stack.pop();
                } else {
                    stack.push(p.charAt(i));
                }
            }
        }

        return stack.empty();
    }

    private String getConvertedParenthesis(String p) {
        if (p.length() == 0) {
            return p;
        }

        int divideIndex = getDivideIndex(p);

        String u = p.substring(0, divideIndex + 1);
        String v = p.substring(divideIndex + 1);

        String result = "";

        if (isRightParenthesis(u)) {
            result = getConvertedParenthesis(v);
            u += result;

            return u;
        } else {
            result += "(";
            result += getConvertedParenthesis(v);
            result += ")";

            u = convertFourStage(u);

            result += u;

            return result;
        }
    }

    private int getDivideIndex(String p){
        int leftCount = 0;
        int rightCount = 0;
        int index;

        for (index = 0 ; index < p.length() ; index++) {
            if (p.charAt(index) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if (leftCount == rightCount) {
                return index;
            }
        }

        return index;
    }

    private String convertFourStage(String u) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0 ; i < u.length() ; i++) {
            if (i == 0 || i == u.length() - 1) {
                continue;
            }
            if (u.charAt(i) == '('){
                answer.append(")");
            } else {
                answer.append("(");
            }
        }

        return answer.toString();
    }
}
