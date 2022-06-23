package programmers.level_1.ponketmon;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{3,1,2,3,4,5});
        System.out.println(result);
    }
    public int solution(int[] nums) {
        int limitCount = nums.length / 2;

        Set<Integer> ponketmons = new HashSet<>();

        // Set에 넣기
        for ( int ponketmon : nums ) {
            ponketmons.add(ponketmon);
        }

        // Set의 길이가 limitCount와 같거나 작으면 Set의 길이 반환, 크면 limitCount반환
        if(ponketmons.size() <= limitCount) {
            return ponketmons.size();
        } else {
            return limitCount;
        }
    }

}
