package baekjoon.bronze.bronze_2.find_alphabet;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        int[] position = new int[26];
        Arrays.fill(position, -1);

        for (int i = 0; i < word.length(); i++) {
            int alphabetIndex = word.charAt(i) - 97;

            // 처음 등장하는 위치이므로, 값이 초기화되어 있을 경우에만 값을 써준다.
            if (position[alphabetIndex] == -1) {
                position[alphabetIndex] = i;
            }
        }

        bw.write(getAlphabetPosition(position));
        bw.flush();
        bw.close();
    }

    private static String getAlphabetPosition(int[] position) {
        List<String> listForJoin = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            listForJoin.add(String.valueOf(position[i]));
        }

        return String.join(" ", listForJoin);
    }
}
