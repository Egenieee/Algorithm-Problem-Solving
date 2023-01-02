package programmers.level_0.babbling;

// babbling의 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));
    }

    public int solution(String[] babbling) {
        int count = 0;

        for (String word : babbling) {
            count += getWordCount(word);
        }

        return count;
    }

    private int getWordCount(String word) {
        List<String> patterns = Arrays.asList("aya", "ye", "woo", "ma");

        for (String pattern : patterns) {
            word = word.replace(pattern, " ");
        }

        if (word.isBlank()) {
            return 1;
        }

        return 0;
    }
}
