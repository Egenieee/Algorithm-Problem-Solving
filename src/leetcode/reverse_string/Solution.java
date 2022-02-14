package leetcode.reverse_string;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseString(new char[] {'a','c'});
    }
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();

        for(char charactor : s) { //자료구조 stack에 하나씩 차례로 push한 다음에
            stack.push(charactor);
        }

        for(int i = 0 ; i < s.length ; i++) { //본 char형 배열에 다시 pop하여 순서대로 담으면 맨 마지막에 넣은 글자가 제일 처음 나오기 때문에
            s[i] = stack.pop();            //뒤집히게 된다.
        }
    }
}
