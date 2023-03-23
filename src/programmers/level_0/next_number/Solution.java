package programmers.level_0.next_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{-1, -2, -3, -4}));
    }

    public int solution(int[] common) {

        if (isArithmeticSequence(common)) {
            return getNextNumberWithArithmetic(common);
        }

        return getNextNumberWithGeometric(common);
    }

    private boolean isArithmeticSequence(int[] common) {
        int diffOne = common[1] - common[0];
        int diffTwo = common[2] - common[1];

        return diffOne == diffTwo;
    }

    private int getNextNumberWithArithmetic(int[] common) {
        int commonDiff = common[1] - common[0];

        return common[common.length - 1] + commonDiff;
    }

    private int getNextNumberWithGeometric(int[] common) {
        int commonRatio = common[1] / common[0];

        return common[common.length - 1] * commonRatio;
    }
}
