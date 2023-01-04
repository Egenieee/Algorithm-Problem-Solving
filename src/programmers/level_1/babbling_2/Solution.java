package programmers.level_1.babbling_2;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public enum Pattern { // 말할 수 있는 단어를 숫자로 대체하기 위한 enum class
        AYA("aya", "0"),
        YE("ye", "1"),
        WOO("woo", "2"),
        MA("ma", "3");

        private final String pattern;
        private final String number;


        Pattern(String pattern, String number) {
            this.pattern = pattern;
            this.number = number;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }

    public int solution(String[] babbling) {
        int count = 0;

        for (String word : babbling) {
            count += getWordCount(word);
        }

        return count;
    }

    private int getWordCount(String word) {
        List<Pattern> patterns = Arrays.asList(Pattern.AYA, Pattern.WOO, Pattern.MA, Pattern.YE);

        for (Pattern pattern : patterns) { // 말할 수 있는 단어가 포함되어 있다면, 숫자로 대체
            word = word.replace(pattern.pattern, pattern.number);
        }

        if (isAllDigit(word) && isNotDuplicated(word)) { // 숫자로 모두 이루어져있어야 말할 수 있다. 단, 연속된 숫자가 나오면 말할 수 없는 단어이다.
            return 1;
        }

        return 0;
    }

    private boolean isAllDigit(String word) { // 모두 숫자로 이루어져있는지 판단하는 함수
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isNotDuplicated(String word) { // 연속된 숫자가 나오는지 판단하는 함수
        char prevNumber = word.charAt(0);

        for (int i = 1; i < word.length(); i++) {
            if (prevNumber == word.charAt(i)) {
                return false;
            }

            prevNumber = word.charAt(i);
        }

        return true;
    }
}
