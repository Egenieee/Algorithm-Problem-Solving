package baekjoon.silver.silver_1.next_palindrome_number;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        for (int i = 1 ; ; i++) {
            String checkNumber = addString(N, String.valueOf(i));

            if (isPalindrome(N + i)) {
                bw.write(checkNumber);
                break;
            }
        }

        bw.flush();
        bw.close();
    }

    private static String addString(String n, String i) {
        StringBuilder stringBuilder = new StringBuilder();

        int carry = 0;
        int idxOfNumberOne = n.length() - 1;
        int idxOfNumberTwo = i.length() - 1;

        while (idxOfNumberOne >= 0 || idxOfNumberTwo >= 0) {
            int value = carry;

            if (idxOfNumberOne >= 0) {
                value += n.charAt(idxOfNumberOne--) - '0';
            }

            if (idxOfNumberTwo >= 0) {
                value += i.charAt(idxOfNumberTwo--) - '0';
            }


            if (value > 9) {
                carry = 1;
                value -= 10;
            } else {
                carry = 0;
            }

            stringBuilder.append(value);
        }

        if (carry > 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }

    private static boolean isPalindrome(String number) {
        // number와 뒤집은 number가 같으면 팰린드롬이다.

        String originNumber = String.valueOf(number);

        StringBuilder sb = new StringBuilder(originNumber);
        String reverseNumber = sb.reverse().toString();

        return originNumber.equals(reverseNumber);
    }
}
