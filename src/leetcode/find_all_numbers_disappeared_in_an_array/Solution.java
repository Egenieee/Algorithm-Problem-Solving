package leetcode.find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findDisappearedNumbers(new int[]{1,1,5}); //배열은 1부터 시작한다.
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] checkNum = new boolean[nums.length + 1]; //hash table 만들어서 사용하기
        int count = nums.length; //배열안에 있는 숫자의 개수 구하기 (범위 구하기)

        for(int num : nums) {//배열로 받은 숫자 하나씩 보면서 있으면 true로 바꾸기. n의 개수보다 작거나 같은 경우에만 고려한다.
            checkNum[num] = true;
        }

        List<Integer> disappearedNums = new ArrayList<>(); //리턴할 리스트 생성

        for(int i = 1; i <= count ; i++) {
            if(!checkNum[i]) { //배열에 있는 숫자가 아니면
                disappearedNums.add(i); //리턴할 리스트에 추가하기
            }
        }
        return disappearedNums;
    }
}
