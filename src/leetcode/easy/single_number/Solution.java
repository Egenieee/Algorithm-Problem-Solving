package leetcode.easy.single_number;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.singleNumber(new int[] {3,1,1,2,2});
    }
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1); // 맵에 나온 숫자를 key로, 나온 횟수를 value로 집어 넣는다.
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = Map.Entry.comparingByValue(); //comparator 사용해서 value값이 가장 작은 map의 키 반환

        Map.Entry<Integer, Integer> minEntry = Collections.min(map.entrySet(), comparator);

        return minEntry.getKey();

    }
}
