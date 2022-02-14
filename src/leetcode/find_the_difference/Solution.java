package leetcode.find_the_difference;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findTheDifference("abcde", "abcdef");
    }
    public char findTheDifference(String s, String t) {
        char[] inputSString = s.toCharArray();
        char[] inputTString = t.toCharArray();
        int alpah = 0;

        for(char charOne : inputTString) {
            alpah += charOne;
        }

        for(char charTwo : inputSString) {
            alpah -= charTwo;
        }

        System.out.println((char)alpah);

        return (char) alpah;
    }
}

//Input: s = "abcd", t = "abcde"
//Output: "e"
//Explanation: 'e' is the letter that was added.
