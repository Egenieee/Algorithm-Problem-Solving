package leetcode.twosum;

//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.twoSum(new int[]{9,3,7}, 10);
    }
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] solutionNums = new int[2];

        for(int i = 0 ; i < length ; i++) {
            for(int j = i + 1 ; j < length ; j++) {
                if(nums[i] + nums[j] == target) {
                    solutionNums[0] = i;
                    solutionNums[1] = j;
                }
            }
        }
        for(int num : solutionNums) {
            System.out.print(num + " ");
        }
        return solutionNums;
    }
}



