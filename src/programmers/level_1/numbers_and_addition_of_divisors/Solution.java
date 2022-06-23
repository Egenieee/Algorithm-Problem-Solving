package programmers.level_1.numbers_and_addition_of_divisors;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(24, 27));
    }

    // 어떤 수의 약수의 개수가 짝수면 그 수를 더하고 홀 수면 그 수를 빼자.
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = 0 ; i <= right - left ; i++) {
            int currentNumber = left + i;
            int countOfDivisors = getNumberOfDivisor(currentNumber);

            if (countOfDivisors % 2 == 0) {
                answer += currentNumber;
            } else {
                answer -= currentNumber;
            }
        }

        return answer;
    }

    private int getNumberOfDivisor(int number) {
        int countOfDivisors = 0;
        int divisor = 1;
        while (divisor <= number) {
            if (number % divisor == 0) {
                countOfDivisors ++;
            }
            divisor++;
        }

        //System.out.printf("숫자 %d의 약수의 개수 : %d\n", number, countOfDivisors);
        return countOfDivisors;
    }
}
