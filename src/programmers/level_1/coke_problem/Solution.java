package programmers.level_1.coke_problem;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 2, 20));
    }

    public int solution(int a, int b, int n) {
        int cokeCount = 0;

        int remainder;
        int dividend = n;
        int quotient = -1;

        while (quotient != 0) {
            quotient = (dividend / a) * b;
            cokeCount += quotient;
            remainder = dividend % a;

            dividend = quotient + remainder;
        }

        return cokeCount;
    }
}
