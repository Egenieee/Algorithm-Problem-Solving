package programmers.maximun_number;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {3, 30, 34, 5, 9}));
    }
    public String solution(int[] numbers) {
        String answer = "";
        String[] strings = new String[numbers.length];

        for(int i = 0 ; i < strings.length ; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        if(strings[0].equals("0")) {
            return "0";
        }

        Arrays.sort(strings, (s, t1) -> (t1 + s).compareTo(s + t1)); //문자열 정렬 하되, 합친 문자열 비교 해보고 순서 바꿈

        for(String num : strings) {
            answer += num;
        }

        return answer;
    }
}
