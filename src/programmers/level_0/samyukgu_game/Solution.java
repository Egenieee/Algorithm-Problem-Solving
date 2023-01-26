package programmers.level_0.samyukgu_game;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(345));
    }

    public int solution(int order) {
        int answer = 0;

        while (order != 0) {
            if (isSamYukGu(order)) {
                answer++;
            }
            order /= 10;
        }
        return answer;
    }

    private boolean isSamYukGu(int order) {
        return order % 10 == 3 || order % 10 == 6 || order % 10 == 9;
    }
}
