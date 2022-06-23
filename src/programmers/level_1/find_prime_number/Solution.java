package programmers.level_one.find_prime_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10));
    }
    public int solution(int n) {
        int answer;

        int[] primeNumbers = getPrimeNumberArray(n);

        for (int i = 0 ; i < n ; i++) {
            if (primeNumbers[i] == 0) {
                continue;
            }

            // 지울 때는 i의 2배인 곳부터 지우기 시작하니까 j = i * 2
            // 증가식은 i의 배수니까 i만큼 계속 더해서 증가.
            for (int j = i * 2 ; j <= n ; j += i) {
                primeNumbers[j] = 0;
            }
        }

        answer = getCountOfPrimeNumbers(primeNumbers);

        return answer;
    }

    // i가 2일 때, 2의 모든 배수를 0으로 만들어야함.
    // 2 -> 4, 6, 8, 10, 12, ...
    // 3 -> 6, 9, 12, 15, 18 ...

    private int[] getPrimeNumberArray(int n) {
        int[] primeNumber = new int[n + 1];

        for (int i = 2 ; i <= n ; i++) {
            primeNumber[i] = i;
        }

        return primeNumber;
    }

    private int getCountOfPrimeNumbers(int[] primeNumbers) {
        int count = 0;

        for (int primeNumber : primeNumbers) {
            if (primeNumber != 0) {
                count++;
            }
        }

        return count;
    }
}