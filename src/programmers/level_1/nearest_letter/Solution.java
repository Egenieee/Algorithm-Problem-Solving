package programmers.level_1.nearest_letter;

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

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                answer.add(-1);
                map.put(s.charAt(i), i);
            } else {
                int diff = i - map.get(s.charAt(i));
                answer.add(diff);
                map.put(s.charAt(i), i);
            }
        }

        return answer;
    }
}
