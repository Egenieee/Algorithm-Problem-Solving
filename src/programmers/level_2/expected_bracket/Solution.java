package programmers.level_2.expected_bracket;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 4, 5));
    }

    public int solution(int n, int a, int b) {
        int answer = 0;

        while (!isMatch(a, b)) {
            a = getNextNumber(a);
            b = getNextNumber(b);

            n = n / 2;

            answer++;
        }

        answer++;

        return answer;
    }

    private boolean isMatch(int a, int b) {
        // 서로 대진하는 경우
        // 차이가 1나고, 둘 중 더 작은 숫자가 홀 수 일때

        int min = Math.min(a, b);

        return Math.abs(a - b) == 1 && isOdd(min);
    }

    private int getNextNumber(int number) {
        if (isOdd(number)) {
            return (number + 1) / 2;
        }

        return number / 2;
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
