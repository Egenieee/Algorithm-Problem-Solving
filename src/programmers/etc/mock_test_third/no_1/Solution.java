package programmers.etc.mock_test_third.no_1;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, 1, 20));
    }

    public int solution(int a, int b, int n) {
        int answer = 0;
        int remain;
        int given;

        while (n >= a) {
            given = (n / a) * b;
            remain = n % a;

            answer += given;

            n = given + remain;
        }

        return answer;
    }
}
