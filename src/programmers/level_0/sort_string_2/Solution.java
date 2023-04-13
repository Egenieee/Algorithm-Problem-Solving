package programmers.level_0.sort_string_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("Dawoon Baboo"));
    }

    public String solution(String my_string) {
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < my_string.length(); i++) {
            strings.add(String.valueOf(Character.toLowerCase(my_string.charAt(i))));
        }

        Collections.sort(strings);

        return String.join("", strings);
    }
}
