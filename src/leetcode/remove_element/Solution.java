package leetcode.remove_element;

public class Solution {
    public static void main(String[] str) {
        Solution solution = new Solution();
        solution.removeElement(new int[]{3,2,2,3} , 3);
    }
    public int removeElement(int[] nums, int val) {
        int count = 0;

        for(int num : nums) {
            if(num != val) {
                nums[count] = num;
                count++;
            }
        }
        
        for(int num : nums) {
            System.out.println("num = " + num);
        }

        //k = 2 이기 때문에 2개 요소 뒤에 뭐가 와도 안봄. k 개수 까지만 확인함.

        return count;
    }
}
