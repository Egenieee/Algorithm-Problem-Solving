package leetcode.easy.buddy_strings;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buddyStrings("abaa", "acaa");
    }

    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false; //s와 goal 길이가 다르면 return false

        List<Integer> difference = new ArrayList<>(); //s와 goal의 서로 다른 알파벳의 index 저장하기 위한 list

        int[] alphabet = new int[26]; //중복되는 알파벳 체크 위한 배열
        boolean hasDuplicates = false; //같은 알파벳이 중복이면 true

        for(int i = 0 ; i < s.length() ; i++) {
            char ch1 = s.charAt(i);
            char ch2 = goal.charAt(i);

            if(ch1 != ch2) { //두 알파벳 서로 다르면
                difference.add(i); //list에 추가
            }

            if(difference.size() > 2) return false; //서로 다른 알파벳이 3자리 이상 되면 return false

            alphabet[ch1 - 'a']++; //들어온 알파벳 a = 0번부터 시작하는 배열에 1씩 증가하며 저장 - 'a' 하는 이유도 소문자 a가 26번이기 때문에 a = 0부터 차례대로 넣기 위함.

            if(alphabet[ch1 - 'a'] > 1) { //중복되는 알파벳이 두개 이상이면
                hasDuplicates = true; //중복이 있는가를 나타내는 변수를 true로 변경한다
            }
        }

        if(difference.size() == 0) { //s와 goal이 똑같은 문자열이라면
            return hasDuplicates; //중복 여부에 따라 결과 달라짐 중복된 알파벳이 있으면 return true 없으면 return false
        }

        if(difference.size() == 1) { //s와 goal 다른 점이 하나밖에 없으면 바로 return false
            return false;
        }

        int idxOfSwap1 = difference.get(0); //서로 다른 알파벳의 인덱스 가져오기
        int idxOfSwap2 = difference.get(1);

        //두 인덱스를 넣고 알파벳이 같은지 비교하기 서로 스왑했을때 같아야 하므로 바꿔서도 비교한다.
        if ((s.charAt(idxOfSwap1) == goal.charAt(idxOfSwap2)) && (s.charAt(idxOfSwap2) == goal.charAt(idxOfSwap1))) {
            return true;
        }

        return false;

    }
}

//s에서 두개의 글자 swap할 수 있음. 다 swap한 뒤에 s와 goal이 같으면 true 다르면 false
//문자열 길이가 2일경우, 문자열내 같은 문자가 2개 이상인 경우, 문자열이 모두 같은 문자로 되어있을 경우
//두 문자열이 모두 다를 경우