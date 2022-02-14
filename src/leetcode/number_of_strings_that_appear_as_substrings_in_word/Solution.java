package leetcode.number_of_strings_that_appear_as_substrings_in_word;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numOfStrings(new String[]{"a", "b", "c"}, "aaaaabbbbb");
    }
    public int numOfStrings(String[] patterns, String word) {
        int check = 0;

        for(String str : patterns) { //패턴에서 하나씩 꺼내서
            if(word.contains(str)) { //단어에 패턴이 있는지 확인한 후, 있으면
                check++; //카운트 증가
            }
        }

        return check;
    }
}

//Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
//Output: 2
//Explanation:
//- "a" appears as a substring in "aaaaabbbbb".
//- "b" appears as a substring in "aaaaabbbbb".
//- "c" does not appear as a substring in "aaaaabbbbb".
//2 of the strings in patterns appear as a substring in word.
