package programmers.level_0.calculating_string;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("-3 - 7"));
    }

    public int solution(String my_string) {
        String[] formula = my_string.split(" ");

        if (formula[1].equals("+")) {
            return plusResult(formula);
        }

        return minusResult(formula);
    }

    private int plusResult(String[] formula) {
        return Integer.parseInt(formula[0]) + Integer.parseInt(formula[2]);
    }

    private int minusResult(String[] formula) {
        return Integer.parseInt(formula[0]) - Integer.parseInt(formula[2]);
    }
}
