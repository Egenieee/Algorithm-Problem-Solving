package programmers.level_0.remove_duplicate_characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("people"));
    }

    public String solution(String my_string) {
        Set<Character> table = new HashSet<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            if (table.isEmpty()) {
                table.add(my_string.charAt(i));
                stringBuilder.append(my_string.charAt(i));
                continue;
            }

            if (!table.contains(my_string.charAt(i))) {
                stringBuilder.append(my_string.charAt(i));
                table.add(my_string.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
