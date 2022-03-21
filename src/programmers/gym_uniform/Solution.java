package programmers.gym_uniform;

// 2번한테 체육복을 빌려줄 수 있는 학생은 3번과 4번
// 여벌 체육복을 가지고 있는 학생이 체육복을 도난당할 수 있다. --> 다른 학생에게 체육복 빌려줄 수 없음.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(6, new int[]{2, 3, 4, 6}, new int[]{1, 3, 5});
        System.out.println(result);
    }
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        for (int i = 0 ; i < lost.length ; i++) {
            for (int j = 0 ; j < reserve.length ; j++) {
                if (lost[i] == reserve[j]) {
                    reserve[j] = Integer.MIN_VALUE;
                    lost[i] = Integer.MIN_VALUE;
                    answer++;
                }
            }
        }

        for (int i = 0 ; i < lost.length ; i++) {
            for (int j = 0 ; j < reserve.length ; j++) {
                if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    reserve[j] = Integer.MIN_VALUE;
                    lost[i] = Integer.MIN_VALUE;
                    answer++;
                }
            }
        }

        return answer;
    }
}
