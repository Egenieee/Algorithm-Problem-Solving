package leetcode.move_zeroes;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.moveZeroes(new int[] {0,3,3,13,0});
    }
    public void moveZeroes(int[] nums) {
        int count = 0; //0이 아닌 숫자 세기위한 변수
        int temp;

        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] != 0) {
                temp = nums[i]; //0이 아닌 수 temp에 저장해 두었다가
                nums[count] = temp; //배열의 첫번째부터 채워넣는다
                count++; //그러고 채워넣은 수 카운트 증가
            }
        }

        for(int j = count ; j < nums.length ; j++) { //채워넣은 수 다음칸부터
            nums[j] = 0; //0으로 채운다
        }

        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}

//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]

//배열 처음부터 훑으며 0만나면 count++; 0아니면 저장해두었다가 배열 처음부터 채워넣기
//count 수 만큼 배열 뒤에 0 채워넣기