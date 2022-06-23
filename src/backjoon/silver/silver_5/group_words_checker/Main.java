package backjoon.silver.silver_5.group_words_checker;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0 ; i < N ; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
    // aaabbbcccb
    // happy
    // 다음 문자와 다름 && 다음 문자 이미 set 안에 존재 --> 그룹 단어 아님
    private static boolean isGroupWord(String word) {
        Set<Character> alphabets = new HashSet<>();

        for (int i = 0 ; i < word.length() - 1 ; i++) {
            alphabets.add(word.charAt(i));
            if (word.charAt(i) != word.charAt(i + 1) && alphabets.contains(word.charAt(i + 1))) {
                return false;
            }
        }

        return true;
    }
}
