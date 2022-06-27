package programmers.level_1.place_integers_in_descending_order;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(124342351));
    }
    public long solution(long n) {
        long answer;

        String[] numbers = String.valueOf(n).split("");

        Arrays.sort(numbers, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (String num : numbers){
            sb.append(num);
        }

        answer = Long.parseLong(sb.toString());

        return answer;
    }
}
