package programmers.level_0.share_a_pizza_1;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(15));
    }

    public int solution(int n) {
        int remain = n % 7;
        int answer = n / 7;

        if (remain > 0) {
            answer++;
        }

        return answer;
    }
}
