package programmers.level_0.number_of_k;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1, 13, 1));
    }

    public int solution(int i, int j, int k) {
        int answer = 0;

        for (int start = i; start <= j; start++) {
            answer += getCountOfKInNumber(start, k);
        }

        return answer;
    }

    private int getCountOfKInNumber(int start, int k) {
        String number = String.valueOf(start);
        int count = 0;

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) - '0' == k) {
                count++;
            }
        }

        return count;
    }
}
