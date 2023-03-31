package programmers.level_0.find_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(132324, 3));
    }

    public int solution(int num, int k) {
        String number = String.valueOf(num);

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) - '0' == k) {
                return i + 1;
            }
        }

        return -1;
    }
}
