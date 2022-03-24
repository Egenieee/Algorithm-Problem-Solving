package programmers.find_prime_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10));
    }
    public int solution(int n) {
        int answer = 0;

        for (int i = 2 ; i <= n ; i++) {
            if (isPrimeNumber(i)) {
                answer++;
            }
        }

        return answer;
    }
    private boolean isPrimeNumber(int n) {
        int divisor = 2;
        boolean isPrime = true;

        while (divisor < n) {
            if (n % divisor == 0) { // 1과 자기자신 제외한 다른 수로 나눠지면 소수 아님
                return false;
            }
            divisor++;
        }

        return isPrime;
    }
}

// 2, 3, 5, 7

// 5 -> 2, 3, 4,