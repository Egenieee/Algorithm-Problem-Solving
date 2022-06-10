package programmers.gym_suit;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(5, new int[]{3, 2}, new int[]{3, 5, 4});
        System.out.println(result);
    }
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복 있는 애가 도난 당할 경우 다른 친구 못 빌려주게 처리
        for (int i = 0 ; i < lost.length ; i++) {
            for (int j = 0 ; j < reserve.length ; j++) {
                if (lost[i] != -3 && reserve[j] != -3 && lost[i] == reserve[j]) {
                    reserve[j] = -3;
                    lost[i] = -3;
                    answer++;
                }
            }
        }

        for (int i = 0 ; i < lost.length ; i++) {
            for (int j = 0 ; j < reserve.length ; j++) {
                if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    reserve[j] = -3;
                    lost[i] = -3;
                    answer++;
                }
            }
        }

        return answer;
    }
}
