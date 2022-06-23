package programmers.level_one.k_th_number;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution.solution(array, commands)));
    }

    private int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int pointer = 0;

        for (int[] command : commands) {
            answer[pointer] = getKNumber(array, command);
            pointer++;
        }

        return answer;
    }

    private int getKNumber(int[] array, int[] command) {
        int start = command[0] - 1;
        int end = command[1];
        int k = command[2] - 1;

        int[] sliced = Arrays.copyOfRange(array, start, end);

        Arrays.sort(sliced);

        return sliced[k];
    }
}
