package leetcode.add_digits;

import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addDigits(38);
    }
    public int addDigits(int num) {
        int sum = 0;
        int[] digits = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray(); //int형 배열로 바꿈
        if(digits.length == 1) { //배열의 길이가 1이면, 즉 한자리 수 이면 그 수 반환
            System.out.println(digits[0]);
            return digits[0];
        } else if(digits.length >= 2) { //배열의 길이가 2 이상이면,
            for(int number : digits) {
                sum += number; //배열 요소 각각 더한다.
            }
        }
        return addDigits(sum); //recursion 사용하여, 합한 수 넘겨서 다시 계산하게 함.
    }
}

//Input: num = 38
//Output: 2
//Explanation: The process is
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2
//Since 2 has only one digit, return it.
