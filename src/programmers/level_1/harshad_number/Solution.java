package programmers.level_1.harshad_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(12));
    }
    public boolean solution(int x) {
        boolean answer = false;
        int sum = 0;

        String number = String.valueOf(x);
        char[] numbers = number.toCharArray();

        for (char num : numbers) {
            sum += (num - '0');
        }

        if (x % sum == 0) {
            answer = true;
        }

        return answer;
    }
}
