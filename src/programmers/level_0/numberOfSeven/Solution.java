package programmers.level_0.numberOfSeven;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{10, 7, 87}));
    }

    public int solution(int[] array) {
        int numberOfSeven = 0;

        for (int number : array) {
            numberOfSeven += getNumberOfSeven(number);
        }

        return numberOfSeven;
    }

    private int getNumberOfSeven(int number) {
        int numberOfSeven = 0;
        String numberToString = String.valueOf(number);

        while (numberToString.length() != 0) {
            if (numberToString.charAt(0) == '7') {
                numberOfSeven++;
            }
            numberToString = numberToString.substring(1);
        }

        return numberOfSeven;
    }

}
