package leetcode.easy.plus_one;

public class Solution {
    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.plusOne(new int[] {9,8,9,9,9});
    }
    public int[] plusOne(int[] digits) {
        int count = 1; //더하는 수

        for(int i = digits.length - 1 ; i >= 0 ; i--) {
            digits[i] += count;

            if(digits[i] != 10) { //올림수가 없으면
                count = 0; //count는 0
            } else if(digits[i] == 10) { //10이 되면
                count = 1;//올림수는 1이 된다.
                if(i != 0) { //맨 처음일 경우 제외
                    digits[i] = 0;
                }
            }
        }

        if(digits[0] == 10) { //맨 처음수가 10이면
            int[] newDigits = new int[digits.length + 1]; //배열 길이를 하나 더 늘린다.

            newDigits[0] = 1; //배열의 첫번째 요소 1로 저장
            newDigits[newDigits.length - 1] = 0; //맨 마지막은 0으로 저장

            return newDigits; //자리수가 늘어난 경우엔 새로만든 배열 리턴
        }

        return digits; //아니면 기존의 배열 리턴
    }
}

//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
