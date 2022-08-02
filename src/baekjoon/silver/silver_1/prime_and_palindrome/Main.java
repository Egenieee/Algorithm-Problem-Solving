package baekjoon.silver.silver_1.prime_and_palindrome;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[] primeArray = getPrimeArray();

//        for (int i = 0 ;i < primeArray.length ; i++) {
//            if (!primeArray[i]) {
//                System.out.print(i + " ");
//            }
//        }

        for (int i = N; i < primeArray.length; i++) {
            if (!primeArray[i]) {
                if (isPalindrome(i)) {
                    bw.write(String.valueOf(i));
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
    }

    private static boolean[] getPrimeArray() {
        boolean[] primeArray = new boolean[2000002];

        primeArray[0] = true;
        primeArray[1] = true;

        for (int i = 2; i < primeArray.length; i++) {
            if (primeArray[i]) {
                continue;
            }
            for (int j = 2 * i; j < primeArray.length; j += i) {
                primeArray[j] = true;
            }
        }

        return primeArray;
    }

    private static boolean isPalindrome(int primeNumber) {
        Stack<Character> stack = new Stack<>();

        String number = String.valueOf(primeNumber);
        int length = number.length() / 2;

        if (number.length() % 2 == 0) { // 짝수일 경우

            for (int i = 0; i < length; i++) {
                stack.add(number.charAt(i));
            }

            for (int j = length; j < number.length(); j++) {
                if (stack.pop() != number.charAt(j)) {
                    return false;
                }
            }
        } else { // 홀수일 경우
            for (int i = 0; i < length; i++) {
                stack.add(number.charAt(i));
            }

            for (int j = length + 1; j < number.length(); j++) {
                if (stack.pop() != number.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
