package leetcode.easy.check_if_one_string_swap_can_make_strings_equal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.areAlmostEqual("aa", "ac");
    }
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true; //두 문자열 같으면 return true
        if(s1.length() != s2.length()) return false; //두 문자열 길이 다르면 return false

        List<Integer> difference = new ArrayList<>(); //서로 다른 문자열의 인덱스 번호 저장하기 위한 list

        for(int i = 0 ; i < s1.length() ; i++) {
            char one = s1.charAt(i);
            char two = s2.charAt(i);

            if(one != two) {
                difference.add(i); //서로 다르면 list에 저장
            }

            if(difference.size() > 2) return false; //서로 다른 문자열 3개 이상이면 바로 return false
        }

        if(difference.size() == 1) return false; //서로 다른 문자열이 하나뿐이면 return false

        int idxOfOne = difference.get(0);
        int idxOfTwo = difference.get(1);

        //서로 다른 문자열의 인덱스 하나씩 꺼내서 서로 스왑이 가능한지 체크하기
        if((s1.charAt(idxOfOne) == s2.charAt(idxOfTwo)) && (s1.charAt(idxOfTwo) == s2.charAt(idxOfOne))) {
            return true;
        } else {
            return false;
        }

    }
}
