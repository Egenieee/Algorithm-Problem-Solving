package programmers.level_0.cursed_number_3;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("\n" + solution.solution(15));
    }

    public int solution(int n) {
        int count = 0;
        int number = 0;

        while (count < n) {
            if (isNotThree(number)) {
                count++;
                System.out.println(number);
            }

            number++;
        }

        return --number;
    }

    private boolean isNotThree(int number) {
        return !isThreeInString(number) && !isMultipleThree(number);
    }

    private boolean isMultipleThree(int number) {
        return number % 3 == 0;
    }

    private boolean isThreeInString(int number) {
        String stringNumber = String.valueOf(number);

        for (int i = 0; i < stringNumber.length(); i++) {
            if (stringNumber.charAt(i) - '0' == 3) {
                return true;
            }
        }

        return false;
    }
}
