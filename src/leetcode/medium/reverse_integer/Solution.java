package leetcode.medium.reverse_integer;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverse(-3330);
    }
    public int reverse(int x) {
        String originalNum = Integer.toString(x);
        String[] originalNums = originalNum.split("");
        ArrayList<String> reverseNums = new ArrayList<>();

        if(originalNums[0].equals("-")) {
            reverseNums.add(0, "-");
            for(int i = originalNums.length - 1 ; i > 0 ; i--) {
                reverseNums.add(originalNums[i]);
            }
            if(originalNums[originalNums.length - 1].equals("0")) {
                if(originalNums.length == 1) {
                    reverseNums.add(0,"0");
                }
                reverseNums.remove(1);
            }
        } else {
            for(int j = originalNums.length - 1; j >= 0 ; j--) {
                reverseNums.add(originalNums[j]);
            }
            if(originalNums[originalNums.length - 1].equals("0")) {
                if(originalNums.length == 1) {
                    reverseNums.add(0,"0");
                }
                reverseNums.remove(0);
            }
        }

        String reverseNumToString = String.join("",reverseNums);
        long reverseNum = Long.parseLong(reverseNumToString);
        System.out.println(reverseNum);

        if(reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reverseNum;
    }
}

//배열로 바꾼뒤 뒤집기?

//Input: x = 123
//Output: 321

//Input: x = 120
//Output: 21

//Input: x = -123
//Output: -321
