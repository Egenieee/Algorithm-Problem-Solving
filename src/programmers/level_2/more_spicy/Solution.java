package programmers.level_2.more_spicy;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{5, 4, 2, 3, 1}, 10));
    }
    public int solution(int[] scoville, int K) {
        int mixCount = 0;

        PriorityQueue<Integer> foods = new PriorityQueue<>();

        for (int food : scoville) {
            foods.add(food);
        }

        while (foods.peek() < K && foods.size() != 1) {
            int mix = (foods.poll()) + (foods.poll() * 2);
            foods.add(mix);
            mixCount++;
        }

        if (foods.peek() < K) {
            mixCount = -1;
        }

        return mixCount;
    }
}
