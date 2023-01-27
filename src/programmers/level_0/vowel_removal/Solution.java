package programmers.level_0.vowel_removal;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("nice to meet you"));
    }

    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            if (isNotVowel(my_string.charAt(i))) {
                answer.append(my_string.charAt(i));
            }
        }

        return answer.toString();
    }

    private boolean isNotVowel(char letter) {
        return letter != 'a' && letter != 'e' && letter != 'i' && letter != 'o' && letter != 'u';
    }
}
