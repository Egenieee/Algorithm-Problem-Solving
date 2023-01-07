package programmers.level_0.get_mode;

// 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
// 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 1, 2, 2}));
    }

    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int number : array) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());

        entryList.sort((numberOne, numberTwo) -> numberTwo.getValue() - numberOne.getValue());

        return getMode(entryList);
    }

    private int getMode(List<Map.Entry<Integer, Integer>> entryList) {
        int maxMode = entryList.get(0).getValue();
        int modeCount = 0;

        for (Map.Entry<Integer, Integer> entry : entryList) {
            if (modeCount > 1) {
                return -1;
            }

            if (maxMode == entry.getValue()) {
                modeCount++;
            }
        }

        if (modeCount > 1) {
            return -1;
        }

        return entryList.get(0).getKey();
    }
}
