package leetcode.easy.third_maximum_number;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.thirdMax(new int[] {1,2,2,4});
    }
    public int thirdMax(int[] nums) {
        if(nums == null) return 0;

        int index = nums.length - 1;
        Arrays.sort(nums); //배열을 오름차순 배열을 한 뒤에,

        Set<Integer> integerSet = new LinkedHashSet<>(); //중복허용 안되지만 순서가 있는 LinkedHashSet을 이용한다

        for(int idxOfSet = 0 ; idxOfSet < nums.length ; idxOfSet++) { //가장 큰 수가 있는 뒤에부터 set에 넣는다.
            integerSet.add(nums[index--]);
        }

        List<Integer> integerList = new ArrayList<>(integerSet); //set을 list로 변환한다.

        if(integerList.size() > 2) { //리스트의 사이즈가 3이상이면, 즉, 3번째로 큰 수가 존재하면
            return integerList.get(2); //3번째로 큰 수 반환
        } else { //아니면, 즉, 3번째가 큰 수가 존재하지 않으면
            return integerList.get(0); //첫번째로 큰 수 반환
        }
    }
}
