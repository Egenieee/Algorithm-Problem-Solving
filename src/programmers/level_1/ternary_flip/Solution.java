package programmers.level_one.ternary_flip;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(125));
    }

    public int solution(int n) {
        String ternary = convertToTernaryNumber(n);
        String flipTernary = flip(ternary);

        return convertToDecimalNumber(flipTernary);
    }

    private String convertToTernaryNumber(int decimalNumber) {
        StringBuilder stringBuilder = new StringBuilder();

        while (decimalNumber != 0) {
            stringBuilder.append(decimalNumber % 3);
            decimalNumber /= 3;
        }

        return stringBuilder.reverse().toString();
    }

    private String flip(String ternaryNumber) {
        return new StringBuilder(ternaryNumber).reverse().toString();
    }

    private int convertToDecimalNumber(String flipTernary) {
        return Integer.parseInt(flipTernary, 3);
    }
}
