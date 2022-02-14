package leetcode.word_pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.wordPattern("abaa", "dog cat dog dog");//true
    }
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" "); //스트링을 공백 기준으로 쪼개준다.

        if(pattern.length() != words.length) { //패턴의 길이와 스트링배열의 길이가 다르면 서로 다른 것이므로 False반환
            return false;
        }

        Map<Character, String> map = new HashMap<>(); //Map을 이용한다.

        for(int i = 0 ; i < words.length ; i++) { //words의 길이만큼 반복한다.
            char charactor = pattern.charAt(i); //패턴에서 한글자를 꺼내 변수에 저장한다.
            if(map.containsKey(charactor)) { //charactor가 key가 된다. pattern에 있는 글자가 키로 map에 존재하면
                if(!map.get(charactor).equals(words[i])) { //해당 키의 value가 words의 값과 같은지 비교한다.
                    return false; //같으면 넘어가고 다르면 false반환.
                }
            } else if(!map.containsValue(words[i])){ //words에 있는 단어 중 map에 없는 value를 만나면
                map.put(charactor, words[i]); //map에 key = chractor, value = words[i]로 put한다.
            } else { //새로운 패턴 글자 + 기존에 words에 있던 value 가 만나면 false 반환.
                return false;
            }
        }

        return true; //모두 다 통과하면 true 반환
    }
}

//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
