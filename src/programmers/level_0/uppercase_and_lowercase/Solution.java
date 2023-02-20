package programmers.level_0.uppercase_and_lowercase;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("DaWooN Babo"));
    }

    public String solution(String my_string) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            String letter = getOppositeLetter(my_string.charAt(i));
            stringBuilder.append(letter);
        }

        return stringBuilder.toString();
    }

    private String getOppositeLetter(char letter) {
        if (letter == ' ') {
            return " ";
        }

        if (Character.isUpperCase(letter)) {
            return String.valueOf((char) (letter + 32));
        }

        return String.valueOf((char) (letter - 32));
    }
}
