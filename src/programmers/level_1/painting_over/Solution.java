package programmers.level_1.painting_over;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, 1, new int[]{1, 2, 3, 4}));
    }

    public int solution(int n, int m, int[] section) {
        int paintingCount = 0;
        int maxPaintedIndex = 0;

        for (int part : section) {
            if (part > maxPaintedIndex) {
                maxPaintedIndex = part - 1 + m;
                paintingCount++;
            }
        }

        return paintingCount;
    }
}
