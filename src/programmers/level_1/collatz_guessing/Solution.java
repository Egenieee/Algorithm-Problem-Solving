package programmers.level_1.collatz_guessing;

// 1-1. 입력된 수가 짝수라면 2로 나눕니다.
// 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
// 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(626331));
    }
    public int solution(int num) {
        int count = 0;
        long answer = num;

        while (answer != 1) {
            answer = getAnswer(answer);
            count++;
            if (count >= 500) {
                count = -1;
                break;
            }
        }

        return count;
    }
    private long getAnswer(long num) {
        if (num == 1) {
            return num;
        }
        if (num % 2 == 0) {
            return num / 2;
        }

        return num * 3 + 1;
    }
}
