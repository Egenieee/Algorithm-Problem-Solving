package programmers.level_0.control_z;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("10 20 Z 40"));
    }

    public int solution(String s) {
        String[] numbers = s.split(" ");
        int answer = 0;

        for (int i = 0; i < numbers.length; i++) {
            answer += getNumber(numbers, i);
        }

        return answer;
    }

    private int getNumber(String[] numbers, int i) {
        if (numbers[i].equals("Z")) {
            int number = Integer.parseInt(numbers[i - 1]);

            return -number;
        }

        return Integer.parseInt(numbers[i]);
    }
}
