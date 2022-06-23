package baekjoon.silver.silver_3.make_palindrome;

import java.io.*;

public class Main {
    static int[] alphabets = new int[26];
    static int[] alphabetsUse = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        bw.write(getPalindrome(input));
        bw.flush();
        bw.close();
    }

    private static String getPalindrome(String input) {
        boolean isInputLengthOdd = false;

        for (int i = 0 ; i < input.length() ; i++) {
            char alphabet = input.charAt(i);
            alphabetsUse[alphabet - 65]++;
            alphabets[alphabet - 65]++;
        }

        if (cantMakePalindrome()) {
            return "I'm Sorry Hansoo";
        }

        if (input.length() % 2 != 0) {
            isInputLengthOdd = true;
        }

        return palindrome(isInputLengthOdd);
    }

    private static boolean cantMakePalindrome() {
        int count = 0;

        for (int alphabet : alphabets) {
            if (alphabet % 2 == 1) {
                count++;
            }
        }

        return count > 1;
    }

    private static String palindrome(boolean isInputLengthOdd) {
        StringBuilder answer = new StringBuilder();

        // 팰린드롬 앞부분
        for (int i = 0 ; i < alphabetsUse.length ; i++) {
            int countOfAlphabet = alphabetsUse[i] / 2;

            answer.append(fillPalindrome(i, countOfAlphabet));
        }

        if (isInputLengthOdd) {
            answer.append(getMiddleAlphabet());
        }

        // 팰린드롬 뒷부분
        for (int i = alphabetsUse.length - 1 ; i >= 0 ; i--) {
            int countOfAlphabet = alphabetsUse[i];

            if (alphabetsUse[i] == 1) {
                countOfAlphabet = 1;
            }

            answer.append(fillPalindrome(i, countOfAlphabet));
        }

        return answer.toString();
    }

    private static String fillPalindrome(int idxOfAlphabet, int countOfAlphabet) {
        StringBuilder answer = new StringBuilder();
        int count = 0;

        while (count < countOfAlphabet) {

            answer.append((char) (idxOfAlphabet + 65));
            alphabetsUse[idxOfAlphabet]--;

            count++;
        }

        return answer.toString();
    }

    private static String getMiddleAlphabet() {
        for (int i = 0 ; i < alphabets.length ; i++) {
            if (alphabets[i] % 2 == 1) {
                alphabetsUse[i]--;
                return String.valueOf((char) (i + 65));
            }
        }

        return "?";
    }
}
