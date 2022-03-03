package programmers.repeat_binary_transformation;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> result = solution.solution("110010101001");
        System.out.println(result);
    }
    public List<Integer> solution(String s) {
        int countOfZeroes = 0;
        int countOfTransform = 0;

        do {
            countOfZeroes += getZeroCount(s);

            s = s.replaceAll("0", "");

            int countOfDigits = s.length();

            s = Integer.toBinaryString(countOfDigits);

            countOfTransform++;

        } while(s.length() != 1);

        return Arrays.asList(countOfTransform, countOfZeroes);
    }

    private int getZeroCount(String string) {
        return (int) string.chars()
                .filter(c -> c == '0')
                .count();
    }
}
