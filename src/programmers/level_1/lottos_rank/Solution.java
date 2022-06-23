package programmers.level_1.lottos_rank;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{31, 10, 45, 1, 6, 19})));
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        boolean isWinNum;
        int win_count = 0;
        int unknown_count = 0;

        int best_rank;
        int worst_rank;

        Map<Integer, Integer> lotto_rank = new HashMap<>();
        List<Integer> lotto_nums = new ArrayList<>();

        lotto_rank.put(6, 1);
        lotto_rank.put(5, 2);
        lotto_rank.put(4, 3);
        lotto_rank.put(3, 4);
        lotto_rank.put(2, 5);
        lotto_rank.put(0, 6);

        for (int num : lottos) {
            lotto_nums.add(num);
        }

        // 당첨 번호 하나씩 보면서 산 로또에 있는 지 확인
        for (int num : win_nums) {
            isWinNum = lotto_nums.contains(num);

            // 당첨 번호에 있으면 카운트 증가
            if(isWinNum) {
                win_count++;
            }
        }

        // 최저 순위는 카운트 수 그대로, 최고 순위는 카운트 수 + 0의 개수 만큼으로 등수 계산하자.

        for (int num : lottos) {
            if(num == 0) {
                unknown_count++;
            }
        }

        best_rank = win_count + unknown_count;
        worst_rank = win_count;

        if (best_rank == 1) {
            answer[0] = 6;
            answer[1] = 6;
            return answer;
        }

        if (worst_rank == 1) {
            answer[0] = lotto_rank.get(best_rank);
            answer[1] = 6;
            return answer;
        }

        answer[0] = lotto_rank.get(best_rank);
        answer[1] = lotto_rank.get(worst_rank);

        return answer;
    }
}
