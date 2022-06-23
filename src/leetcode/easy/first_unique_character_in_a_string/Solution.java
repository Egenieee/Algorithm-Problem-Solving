package leetcode.easy.first_unique_character_in_a_string;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.firstUniqChar("loveleetcode");
    }
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>(); //hashMap을 이용한다.

        for(int i = 0 ; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1); //스트링 길이만큼 반복하며 1씩 더하여 value값을 추가한다.
        } //이렇게 저장을 하게 되면, 2번이상 중복된 알파벳의 value는 2 이상일 것이다.

        for(int j = 0 ; j < s.length() ; j++) { //다시 처음부터 for문을 돌며 중복되지 않은 첫번째 알파벳을 찾아서 그 알파벳의 인덱스를 리턴한다.
            if(map.get(s.charAt(j)) == 1) {
                System.out.println("index = " + j);
                return j;
            }
        }

        return -1;
    }
}

//Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

//Input: s = "leetcode"
//Output: 0

//Input: s = "loveleetcode"
//Output: 2

//첫번째 비반복 글자의 인덱스를 반환해