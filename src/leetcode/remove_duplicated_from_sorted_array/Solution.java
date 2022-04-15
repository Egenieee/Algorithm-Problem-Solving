package leetcode.remove_duplicated_from_sorted_array;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }
    public int removeDuplicates(int[] nums) {
        // 중복된 숫자를 없앤 뒤, 남은 숫자만 남기기
        int length = nums.length;
        int idx = 0;

        Map<Integer, Integer> check = new LinkedHashMap<>();

        for (int num : nums) {
            check.put(num, check.getOrDefault(num, 0) + 1);
        }

        for (int num : check.keySet()) {
            nums[idx++] = num;
        }

        return idx;

    }
}
