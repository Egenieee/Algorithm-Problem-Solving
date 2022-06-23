package programmers.level_3.camouflage;

// Map<String, String> clothes = new HashMap<>();
// <의상 이름, 의상 종류>
// 의상의 총 개수 + 조합 공식..?

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "headgear"},
                {"green_turban", "headgear"}}));
    }
    public int solution(String[][] clothes) {
        int answer;
        Map<String, String> clothesCombination = new HashMap<>();

        for (String[] cloth : clothes) {
            clothesCombination.put(cloth[0], cloth[1]);
        }

        // 구한 가능한 조합의 수에서 아무것도 안 입었을 경우 1 제외
        answer = getCombinationCount(clothesCombination) - 1;

        return answer;
    }

    // 종류별로 개수를 구해야 함..
    // 어떻게 구하지? Map 쓰자
    private int getCombinationCount(Map<String, String> clothCombination) {
        Map<String, Integer> clothTypeCount = new HashMap<>();

        // 의상 종류 별로 개수 구함
        for (String cloth : clothCombination.keySet()) {
            clothTypeCount.put(clothCombination.get(cloth), clothTypeCount.getOrDefault(clothCombination.get(cloth), 0) + 1);
        }

        // 의상 종류 : 개수
        // A : 3
        // A : 2, B : 1
        // A : 2, B : 3, C : 1

        int combinationCount = 1;

        for (String type : clothTypeCount.keySet()) {
            // 각 의상 종류의 개수(해당 종류에서 고를 수 있는 선택지) + 1(의상을 안 걸칠 때의 경우)를 종류마다 곱한다. -> 입을 수 있는 전체 조합의 수
            combinationCount *= (clothTypeCount.get(type) + 1);
        }

        return combinationCount;
    }
}
