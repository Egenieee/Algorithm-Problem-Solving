package backjoon.bronze.bronze_2.string_repeat;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        StringBuilder repeated;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            repeated = new StringBuilder();
            st = new StringTokenizer(br.readLine());

            int repeatNum = Integer.parseInt(st.nextToken());
            String word = st.nextToken();

            repeated.append(repeat(repeatNum, word));
            bw.write(repeated.toString() + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static String repeat(int repeatNum, String word) {
        StringBuilder repeated = new StringBuilder();

        for (int i = 0 ; i < word.length() ; i++) {
            repeated.append(repeatEachAlphabet(repeatNum, word.charAt(i)));
        }

        return repeated.toString();
    }

    private static String repeatEachAlphabet(int repeatNum, char letter) {
        StringBuilder repeated = new StringBuilder();

        for (int i = 0 ; i < repeatNum ; i++) {
            repeated.append(letter);
        }

        return repeated.toString();
    }
}
