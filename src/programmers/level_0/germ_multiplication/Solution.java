package programmers.level_0.germ_multiplication;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(7, 15));
    }

    public int solution(int n, int t) {
        return (int) (Math.pow(2, t) * n);
    }
}
