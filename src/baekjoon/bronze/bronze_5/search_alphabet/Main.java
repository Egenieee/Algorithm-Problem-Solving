package baekjoon.bronze.bronze_5.search_alphabet;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // String 형식으로 들어옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String id = br.readLine();

        int[] alphabets = new int[26];

        Arrays.fill(alphabets, -1);

        for (int i = 0; i < id.length(); i++) {
            int alphabet = id.charAt(i); // b
            if (alphabets[alphabet - 97] == -1) {
                alphabets[alphabet - 97] = i;
            }
        }

        List<String> answer = new ArrayList<>();

        for (int position : alphabets) {
            answer.add(String.valueOf(position));
        }

        bw.write(String.join(" ", answer));

        bw.flush();
        bw.close();
    }
}

