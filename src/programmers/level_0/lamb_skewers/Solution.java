package programmers.level_0.lamb_skewers;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 3));
    }

    public int solution(int n, int k) {
        int service = n / 10;
        return (n * 12000 + k * 2000) - service * 2000;
    }
}
