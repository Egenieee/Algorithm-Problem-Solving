package programmers.level_0.close_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{10, 20, 28, 12, 12, 20}, 1));
    }

    public int solution(int[] array, int n) {
        int minDiff = Integer.MAX_VALUE;
        int closeNumber = 0;

        for (int number : array) {
            int diff = Math.abs(n - number);

            if (minDiff == diff) {
                if (number < closeNumber) {
                    closeNumber = number;
                }
            }

            if (minDiff > diff) {
                closeNumber = number;
                minDiff = diff;
            }
        }

        return closeNumber;
    }
}
