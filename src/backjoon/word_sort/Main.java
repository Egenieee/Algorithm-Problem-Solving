package backjoon.word_sort;

// 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
//1. 길이가 짧은 것부터
//2. 길이가 같으면 사전 순으로

import java.io.*;
import java.util.*;

public class Main {
    static class Word implements Comparable<Word> {
        private final String word;

        public Word(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }

        public int getLength() {
            return word.length();
        }

        @Override
        public int compareTo(Word o) {
            if (word.length() == o.getLength()) {
                return word.compareTo(o.getWord());
            }

            return word.length() - o.getLength();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> duplicatedWordRemove = new HashSet<>();

        for (int i = 0 ; i < N ; i++) {
            duplicatedWordRemove.add(br.readLine());
        }

        List<Word> words = new ArrayList<>();

        for (String word : duplicatedWordRemove) {
            words.add(new Word(word));
        }

        Collections.sort(words);

        for (Word word : words) {
            bw.write(word.getWord() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
