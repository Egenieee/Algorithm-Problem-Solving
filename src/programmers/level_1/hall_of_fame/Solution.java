package programmers.level_1.hall_of_fame;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
    }

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        Queue<Integer> hallOfFame = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            hallOfFame.add(score[i]);

            if (hallOfFame.size() > k) {
                hallOfFame.poll();
            }

            answer[i] = hallOfFame.peek();
        }

        return answer;
    }
}
