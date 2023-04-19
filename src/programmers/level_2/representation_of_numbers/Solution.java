package programmers.level_2.representation_of_numbers;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1));
    }

    public int solution(int n) {
        int answer = 0;

        int limitCount = getLimitCount(n);

        for (int i = 1; i <= limitCount; i++) {
            if (isValid(n, i)) {
                answer++;
            }
        }

        return answer;
    }

    private int getLimitCount(int n) {
        int sum = 0;
        int i;

        for (i = 1; i <= n; i++) {
            sum += i;

            if (sum >= n) {
                return i;
            }
        }

        return i;
    }

    private boolean isValid(int n, int count) {
        if (count % 2 == 0) {
            int k = n / count;
            return (count * k) + (count / 2) == n;
        }

        return n % count == 0;
    }
}
