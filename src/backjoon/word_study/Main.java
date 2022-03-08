package backjoon.word_study;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Mississipi
        String word = br.readLine();

        //가장 많이 사용된 알파벳 찾기. 그 수가 같으면 ? 출력
        List<Integer> alphabetCount = getAlphabetCount(word);
        int max = getMaxCount(alphabetCount);
        List<Integer> maxCountAlphabets = getMaxCountAlphabets(max, alphabetCount);
        char answer = getResult(maxCountAlphabets);

        bw.write(answer);
        bw.flush();
        bw.close();
    }

    public static List<Integer> getAlphabetCount(String word) {
        // 65 = A
        int[] alphabets = new int[26];

        for (int i = 0 ; i < word.length() ; i++) {
            char alphabet = Character.toUpperCase(word.charAt(i));
            alphabets[alphabet - 65]++;
        }

        List<Integer> alphabetCount = new ArrayList<>();
        for (int count : alphabets) {
            alphabetCount.add(count);
        }

        return alphabetCount;
    }

    public static int getMaxCount(List<Integer> alphabetCount) {
        int max = Integer.MIN_VALUE;
        for (int count : alphabetCount) {
            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    public static List<Integer> getMaxCountAlphabets(int max, List<Integer> alphabetCount) {
        List<Integer> maxCountAlphabets = new ArrayList<>();
        for (int i = 0 ; i < alphabetCount.size() ; i++) {
            if (max == alphabetCount.get(i)) {
                maxCountAlphabets.add(i + 65);
            }
        }

        return maxCountAlphabets;
    }

    public static char getResult(List<Integer> maxCountAlphabets) {
        char answer;
        if (maxCountAlphabets.size() == 1) {
            answer = (char) Character.toUpperCase(maxCountAlphabets.get(0));
        } else {
            answer = '?';
        }
        return answer;
    }
}
