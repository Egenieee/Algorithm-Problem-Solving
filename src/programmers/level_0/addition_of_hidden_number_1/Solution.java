package programmers.level_0.addition_of_hidden_number_1;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aAb1B2cC34oOp"));
    }

    public int solution(String my_string) {
        int answer = 0;

        for (int i = 0; i < my_string.length(); i++) {
            if (Character.isDigit(my_string.charAt(i))) {
                answer += my_string.charAt(i) - '0';
            }
        }

        return answer;
    }
}
