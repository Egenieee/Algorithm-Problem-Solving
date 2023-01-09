package programmers.level_2.picking_tangerines;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, new int[]{10, 10, 10, 9, 9}));
    }

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tangerines = new HashMap<>();

        for (int oneTangerine : tangerine) {
            tangerines.put(oneTangerine, tangerines.getOrDefault(oneTangerine, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(tangerines.entrySet());

        entryList.sort((numberOne, numberTwo) -> numberTwo.getValue() - numberOne.getValue());

        return getMinTangerineCount(entryList, k);
    }

    private int getMinTangerineCount(List<Map.Entry<Integer, Integer>> entryList, int k) {
        int minTangerineTypeCount = 0;

        for (Map.Entry<Integer, Integer> tangerine : entryList) {
            /* 여기서 if문으로 k보다 value값이 작은지 확인해버리면, 충분히 귤을 담을 수 있음에도 다음 크기의 귤로 넘어가버리니까, if문으로 안거르고
                일단은 value 기준으로 정렬되어 있으니까 위에서부터 k개씩 담아주고 k값을 value개수 만큼 줄인다. */
            minTangerineTypeCount++;
            k = k - tangerine.getValue();

            if (k < 1) {
                return minTangerineTypeCount;
            }
        }

        return minTangerineTypeCount;
    }
}
