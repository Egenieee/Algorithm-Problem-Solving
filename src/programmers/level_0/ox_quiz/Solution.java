package programmers.level_0.ox_quiz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"}));
    }

    public List<String> solution(String[] quiz) {
        List<String> results = new ArrayList<>();

        for (String oneQuiz : quiz) {
            results.add(getResult(oneQuiz));
        }
        return results;
    }

    private String getResult(String oneQuiz) {
        String[] operators = oneQuiz.split(" ");

        if (operators[1].equals("-")) {
            return getMinusResult(operators);
        }

        return getPlusResult(operators);
    }

    private String getMinusResult(String[] operators) {
        if (Integer.parseInt(operators[0]) - Integer.parseInt(operators[2]) == Integer.parseInt(operators[4])) {
            return "O";
        }

        return "X";
    }

    private String getPlusResult(String[] operators) {
        if (Integer.parseInt(operators[0]) + Integer.parseInt(operators[2]) == Integer.parseInt(operators[4])) {
            return "O";
        }

        return "X";
    }
}
