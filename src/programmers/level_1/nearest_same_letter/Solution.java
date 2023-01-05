package programmers.level_1.nearest_same_letter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("banana"));
    }

    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int index = 0; index < s.length(); index++) {
            saveBeforeSameLetterPosition(map, s, index, answer);
        }

        return answer;
    }

    private void saveBeforeSameLetterPosition(Map<Character, Integer> map, String s, int index, List<Integer> answer) {
        if (!map.containsKey(s.charAt(index))) {
            answer.add(-1);
            map.put(s.charAt(index), index);
            return;
        }

        int beforeSameLetterIndex = index - map.get(s.charAt(index));
        answer.add(beforeSameLetterIndex);
        map.put(s.charAt(index), index);
    }
}
