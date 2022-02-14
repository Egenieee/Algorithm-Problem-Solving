package programmers.string_basic;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1123"));
    }
    public boolean solution(String s) {
        boolean answer = true;

        if(s.length() != 4  && s.length() != 6) {
            answer = false;
        } else {
            for(int i = 0 ; i < s.length(); i++) {
                if(Character.isAlphabetic(s.charAt(i))) {
                    answer = false;
                }
            }
        }

        return answer;
    }
}
