package leetcode.valid_anagram;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isAnagram("ac", "ca");
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {//두 스트링의 길이가 다르면 무조건 false이므로 false리턴.
            return false;
        }

        char[] strOne = s.toCharArray(); //두 스트링을 char배열로 쪼갠다.
        char[] strTwo = t.toCharArray();

        Arrays.sort(strOne); //두 배열을 정렬한다. -> 두 스트링이 anagram이면 정렬한 결과 두 스트링이 일치할 것이다.
        Arrays.sort(strTwo);

        if(Arrays.equals(strOne, strTwo)) { //정렬한 배열이 같으면 true
            return true;
        } else {
            return false; //다르면 false return
        }

    }
}
