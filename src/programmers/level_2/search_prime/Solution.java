package programmers.level_2.search_prime;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //int count = 0;
    Set<Integer> numberPermutation = new HashSet<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("123"));
    }

    public int solution(String numbers) {
        int countOfPrime = 0;

        String[] inputNumbers = getInputNumbers(numbers);
        String[] output = new String[numbers.length()];
        boolean[] visited = new boolean[numbers.length()];

        // 순열 구하기
        for (int digit = 1; digit <= numbers.length(); digit++) {
            getPermutation(inputNumbers, output, visited, 0, digit);
        }

        // 소수인지 확인하기
        for (int number : numberPermutation) {
            if (isPrime(number)) {
                countOfPrime++;
            }
        }

        return countOfPrime;
    }

    private String[] getInputNumbers(String numbers) {
        String[] inputNumbers = new String[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            inputNumbers[i] = String.valueOf(numbers.charAt(i));
        }

        return inputNumbers;
    }

    // curNumLen -> depth, 깊이만큼 순열을 뽑는다.
    // depth는 0부터 시작
    // digit -> 뽑아야 하는 숫자 개수
    // 현재 깊이와 digit이 같다면 순열 만들기 끝 -> 저장하자.
    private void getPermutation(String[] numbers, String[] output, boolean[] visited, int curNumLen, int digit) {
        if (curNumLen == digit) {
            savePermutation(output, digit);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[curNumLen] = numbers[i];
                //count++;
                //System.out.println(Arrays.toString(output) + "curNumLen : " + curNumLen + " visit :" + count);
                getPermutation(numbers, output, visited, curNumLen + 1, digit);
                visited[i] = false;
            }
        }
    }

    private void savePermutation(String[] numbers, int digit) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < digit; i++) {
            sb.append(numbers[i]);
        }
        String number = sb.toString();
        numberPermutation.add(Integer.parseInt(number));
    }

    private boolean isPrime(int number) {
        int divisor = 2;

        if (number <= 1) {
            return false;
        }

        while (divisor < number) {
            if (number % divisor == 0) {
                return false;
            }
            divisor++;
        }

        return true;
    }
}
