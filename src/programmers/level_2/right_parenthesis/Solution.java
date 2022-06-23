package programmers.level_2.right_parenthesis;

// s	answer
//"()()"	true
//"(())()"	true
//")()("	false
//"(()("	false

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("(())()(()"));
    }
    boolean solution(String s) {
        Stack<Character> check = new Stack<>();

        for (int pointer = 0 ; pointer < s.length() ; pointer++) {
            if (s.charAt(pointer) == '(') {
                check.push(s.charAt(pointer));  // ( 괄호만 push해준다.
            } else { // 닫는 괄호 ) 일때는 스택의 사이즈를 확인한다.
                if (check.size() == 0) { // 사이즈가 0이면 올바른 괄호를 만들 수 없다는 뜻이다.
                    return false;
                } else {
                    check.pop(); // 사이즈가 1 이상일 때는 짝맞출 괄호가 있다는 뜻.
                }
            }
        }

        return check.empty();
    }
}
