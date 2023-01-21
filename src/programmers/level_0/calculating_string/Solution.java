package programmers.level_0.calculating_string;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1 + 2 + 3 - 4"));
    }

    public int solution(String my_string) {
        String[] formula = my_string.split(" ");
        int result = Integer.parseInt(formula[0]);

        for (int index = 1; index < formula.length; index += 2) {
            if (formula[index].equals("+")) {
                result = plusResult(formula, index, result);
            } else {
                result = minusResult(formula, index, result);
            }
        }

        return result;
    }

    private int plusResult(String[] formula, int index, int number) {
        return number + Integer.parseInt(formula[index + 1]);
    }

    private int minusResult(String[] formula, int index, int number) {
        return number - Integer.parseInt(formula[index + 1]);
    }
}
