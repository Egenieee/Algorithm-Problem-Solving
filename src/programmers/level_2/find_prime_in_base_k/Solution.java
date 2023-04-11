package programmers.level_2.find_prime_in_base_k;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(110011, 10));
    }

    public int solution(int n, int k) {
        String converted = getConvertedNumber(n, k);

        return getPrimeNumberCount(converted);
    }

    private String getConvertedNumber(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();

        while (n > k) {
            int remainder = n % k;
            stringBuilder.append(remainder);
            n /= k;
        }

        stringBuilder.append(n);

        return stringBuilder.reverse().toString();
    }

    private int getPrimeNumberCount(String converted) {
        int count = 0;
        String[] numbers = converted.split("0");


        for (String number : numbers) {
            if (isNumber(number) && isPrime(number)) {
                count++;
            }
        }

        return count;
    }

    private boolean isNumber(String stringNumber) {
        return !stringNumber.equals("");
    }

    private boolean isPrime(String stringNumber) {
        long number = Long.parseLong(stringNumber);

        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}