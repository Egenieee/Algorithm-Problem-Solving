package programmers.etc.mock_test_third.no_3;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(12, new int[][]{{7, 8}, {4, 6}, {11, 10}}, new int[][]{{2, 2}, {2, 4}, {3, 3}}));
    }

    public int solution(int distance, int[][] scope, int[][] times) {
        int currentTime = 0;

        loop:
        while (currentTime < distance) {
            currentTime++;

            for (int i = 0; i < scope.length; i++) {
                if (isValidScopes(scope[i], currentTime) && isValidTimes(times[i], currentTime)) {
                    break loop;
                }
            }

        }

        return currentTime;
    }

    private boolean isValidTimes(int[] times, int currentTime) {
        int work = times[0];
        int rest = times[1];

        if ((currentTime % (work + rest)) > work || (currentTime % (work + rest)) == 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidScopes(int[] scope, int currentTime) {
        Arrays.sort(scope);

        if (currentTime >= scope[0] && currentTime <= scope[1]) {
            return true;
        }

        return false;
    }
}
