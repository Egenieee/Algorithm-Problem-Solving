package programmers.level_0.characters_that_appear_only_once;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aabbd"));
    }

    public String solution(String s) {
        Map<Character, Integer> table = getTable(s);
        List<String> oneCharacters = getOnlyOnceAppearCharacters(table);

        Collections.sort(oneCharacters);

        return String.join("", oneCharacters);
    }

    private List<String> getOnlyOnceAppearCharacters(Map<Character, Integer> table) {
        List<String> oneCharacters = new ArrayList<>();

        for (Character key : table.keySet()) {
            if (table.get(key) == 1) {
                oneCharacters.add(String.valueOf(key));
            }
        }

        return oneCharacters;
    }

    private Map<Character, Integer> getTable(String s) {
        Map<Character, Integer> table = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            table.put(s.charAt(i), table.getOrDefault(s.charAt(i), 0) + 1);
        }

        return table;
    }
}
