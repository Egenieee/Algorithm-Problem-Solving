package programmers.level_1.number_mates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("100", "2345"));
    }

    public String solution(String X, String Y) {
        int[] numberCounter = getNumberCounter(X);

        List<Integer> numberMates = new ArrayList<>();

        for (int i = 0; i < Y.length(); i++) {
            int index = Y.charAt(i) - '0';

            if (numberCounter[index] > 0) {
                numberMates.add(index);
                numberCounter[index]--;
            }
        }

        if (numberMates.isEmpty()) {
            return "-1";
        }

        numberMates.sort(Collections.reverseOrder());

        if (numberMates.get(0) == 0) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();

        numberMates.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private int[] getNumberCounter(String x) {
        int[] numberCounter = new int[10];

        for (int i = 0; i < x.length(); i++) {
            int index = x.charAt(i) - '0';
            numberCounter[index]++;
        }

        return numberCounter;
    }

}
