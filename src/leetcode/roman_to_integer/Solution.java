package leetcode.roman_to_integer;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.romanToInt("XXI");
    }
    public int romanToInt(String s) {
        String[] romans = s.split("");
        int[] nums = new int[romans.length];
        int result = 0;

        for (int i = romans.length - 1; i >= 0; i--) {
            if (romans[i].equals("I")) {
                nums[i] = 1;
            } else if (romans[i].equals("V")) {
                nums[i] = 5;
            } else if (romans[i].equals("X")) {
                nums[i] = 10;
            } else if (romans[i].equals("L")) {
                nums[i] = 50;
            } else if (romans[i].equals("C")) {
                nums[i] = 100;
            } else if (romans[i].equals("D")) {
                nums[i] = 500;
            } else if (romans[i].equals("M")) {
                nums[i] = 1000;
            }
        }

        for (int j = 0; j < nums.length - 1; j++) { //1,10
            if (nums[j] >= nums[j + 1]) {
                result += nums[j];
            } else {
                result -= nums[j];
            }
        }

        result += nums[nums.length - 1];

        System.out.println("result = " + result);
        return result;
    }

}

//뒤에서 앞으로 읽으면서 자기가 더 크거나 자기와 같은 것이 나오면 더하고 작은 것이 나오면 자기에서 뺀 후 연산 계속

//Input: s = "III"
//Output: 3

//Input: s = "IX"
//Output: 9

//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
