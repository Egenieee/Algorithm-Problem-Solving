package programmers.level_0.ranking;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[][]{{1, 3}, {3, 1}, {2, 3}, {3, 2}, {1, 2}, {0, 0}})));
    }

    public int[] solution(int[][] score) {
        double[] averages = new double[score.length];
        int index = 0;

        for (int[] studentScore : score) {
            double average = getAverage(studentScore);
            averages[index++] = average;
        }

        return getRank(averages);
    }

    private double getAverage(int[] studentScore) {
        double average = 0;

        for (int score : studentScore) {
            average += score;
        }

        average /= 2;

        return average;
    }

    private int[] getRank(double[] average) {
        int[] ranks = new int[average.length];

        int rank = 1;
        double max = Integer.MIN_VALUE;

        while (rank <= average.length) {
            for (double eachScore : average) {
                if (max < eachScore) {
                    max = eachScore;
                }
            }

            // 공동 등수가 있으면 채우기
            int sameRankCount = 0;
            for (int i = 0; i < average.length; i++) {
                if (max == average[i]) {
                    ranks[i] = rank;
                    average[i] = -1;
                    sameRankCount++;
                }
            }

            rank = rank + sameRankCount;
            max = Integer.MIN_VALUE;
        }

        return ranks;
    }
}
