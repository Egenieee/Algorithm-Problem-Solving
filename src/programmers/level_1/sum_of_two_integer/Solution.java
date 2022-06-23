package programmers.level_1.sum_of_two_integer;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 5));
    }
    public long solution(int a, int b) {
        long answer = 0;
        int count = 0;
        int start = Math.min(a, b);

        while (count <= Math.abs(a - b)) {
            answer += start;
            start++;
            count++;
        }

        return answer;
    }
}
