package programmers.level_3.maximun_number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {3, 30, 34, 5, 9}));
    }
    public String solution(int[] numbers) {
        List<String> sortedNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.toList());

        //문자열 정렬 하되, 합친 문자열 비교 해보고 순서 바꿈

        if(sortedNumbers.get(0).equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();

        sortedNumbers.forEach(answer::append);

        return answer.toString();
    }
}
