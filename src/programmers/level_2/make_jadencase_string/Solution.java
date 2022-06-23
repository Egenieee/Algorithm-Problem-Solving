package programmers.level_two.make_jadencase_string;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("3people unFollowed me"));
    }
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        boolean isFirstLetter = true;

        for (int i = 0 ; i < s.length() ; i++) {
            Character currentLetter = s.charAt(i);

            if (currentLetter == ' ') {
                isFirstLetter = true;
                answer.append(currentLetter);
            } else {
                if (isFirstLetter) {
                    answer.append(Character.toUpperCase(currentLetter));
                    isFirstLetter = false;
                } else {
                    answer.append(Character.toLowerCase(currentLetter));
                }
            }
        }

        return answer.toString();
    }
}
