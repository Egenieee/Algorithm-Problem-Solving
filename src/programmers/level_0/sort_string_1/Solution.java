package programmers.level_0.sort_string_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("p2o4i8gj2")));
    }

    public int[] solution(String my_string) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < my_string.length(); i++) {
            if (Character.isDigit(my_string.charAt(i))) {
                numbers.add(my_string.charAt(i) - '0');
            }
        }

        Collections.sort(numbers);

        return numbers.stream()
                .mapToInt(Integer::intValue).toArray();
    }
}
