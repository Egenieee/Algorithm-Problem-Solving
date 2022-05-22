package programmers.fibonacci_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(solution.solution(Integer.parseInt(br.readLine())));
    }

    public long solution(int n) {
        return fibonacci(n);
    }

    private long fibonacci(int n) {
        long[] fibonacciList = new long[100001];

        fibonacciList[0] = 0 % 1234567;
        fibonacciList[1] = 1 % 1234567;

        for (int i = 2; i <= n; i++) {
            fibonacciList[i] = (fibonacciList[i - 1] + fibonacciList[i - 2]) % 1234567;
        }

        return fibonacciList[n];
    }
}
