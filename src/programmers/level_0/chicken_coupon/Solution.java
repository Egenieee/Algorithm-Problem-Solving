package programmers.level_0.chicken_coupon;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(109));
    }

    public int solution(int chicken) {
        int answer = 0;
        int bonus;

        while (chicken > 9) {
            bonus = 0;

            bonus += chicken / 10;
            chicken %= 10;
            chicken += bonus;
            answer += bonus;
        }

        return answer;
    }
}
