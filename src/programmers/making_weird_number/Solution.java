package programmers.making_weird_number;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("try Hi  A");
        System.out.println(result);
    }
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int count = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == ' ') {
                answer.append(Character.toLowerCase(s.charAt(i)));
                count = 0;
            } else {
                if (count % 2 == 0) {
                    answer.append(Character.toUpperCase(s.charAt(i)));
                } else {
                    answer.append(Character.toLowerCase(s.charAt(i)));
                }
                count++;
            }
        }
        return answer.toString();
    }
}
