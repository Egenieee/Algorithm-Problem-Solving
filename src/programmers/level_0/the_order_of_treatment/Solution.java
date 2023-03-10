package programmers.level_0.the_order_of_treatment;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{3, 76, 24})));
    }

    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        for (int i = 0; i < emergency.length; i++) {
            int index = getIndexOfMax(emergency);
            changeIndexOfMax(emergency, index);

            answer[index] = i + 1;
        }

        return answer;
    }

    private int getIndexOfMax(int[] emergency) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < emergency.length; i++) {
            if (max < emergency[i]) {
                max = emergency[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private void changeIndexOfMax(int[] emergency, int index) {
        emergency[index] = -1;
    }
}
