package programmers.level_2.two_or_less_different_bits;

import java.util.ArrayList;
import java.util.List;

// 7	000...0111
// 8	000...1000	4
// 9	000...1001	3
// 10	000...1010	3
// 11	000...1011	2 --> 제일 작음
// 12   000...1100  3
// 13   000...1101  2
// 14   000...1110  2
// 15   000...1111  1

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new long[]{1001,337,0,1,333,673,343,221,898,997,121,1015,665,779,891,421,222,256,512,128,100}));
    }
    public List<Long> solution(long[] numbers) {
        List<Long> answer = new ArrayList<>();

        for (long number : numbers) {
            long fx = f(number);
            answer.add(fx);
        }

        return answer;
    }
    private long f (long number) {
        // number보다 2개 이하로 비트가 다른 수 중에 제일 작은 수

        long min = Long.MAX_VALUE;
        int diff = 0;

        for (int i = 1 ; diff != 2 ; i++) {
            long counterpart = number + i;
            diff = getDiff(number, counterpart);
            if (min > counterpart && diff <= 2) {
                min = counterpart;
            }
        }

        return min;
    }

    private int getDiff(long number, long counterpart) {
        String xor = Long.toBinaryString(number ^ counterpart);
        // 다른 비트 개수 세기
        int count = 0;

        for (int i = 0 ; i <xor.length() ; i++) {
            if (xor.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }
}
