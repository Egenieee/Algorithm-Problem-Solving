package programmers.level_2.h_index;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 1, 7, 8, 9, 10}));
    }
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int h = citations[citations.length / 2];

        while(true) {
            if (isCollectHCount(citations, h)) {
                return h;
            } else {
                h--;
            }
        }
    }

    private boolean isCollectHCount(int[] citations, int h) {
        int count = 0;

        for (int paper : citations) {
            if (paper >= h) {
                count++;
            }
        }

        return count >= h;
    }
}
