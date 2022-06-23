package baekjoon.bronze.bronze_2.dial;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        Map<Character, Integer> time = init();

        int sum = 0;

        for (int i = 0 ; i < word.length() ; i++) {
            sum += time.get(word.charAt(i));
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    private static Map<Character, Integer> init() {
        Map<Character, Integer> time = new HashMap<>();

        time.put('A', 3);
        time.put('B', 3);
        time.put('C', 3);
        time.put('D', 4);
        time.put('E', 4);
        time.put('F', 4);
        time.put('G', 5);
        time.put('H', 5);
        time.put('I', 5);
        time.put('J', 6);
        time.put('K', 6);
        time.put('L', 6);
        time.put('M', 7);
        time.put('N', 7);
        time.put('O', 7);
        time.put('P', 8);
        time.put('Q', 8);
        time.put('R', 8);
        time.put('S', 8);
        time.put('T', 9);
        time.put('U', 9);
        time.put('V', 9);
        time.put('W', 10);
        time.put('X', 10);
        time.put('Y', 10);
        time.put('Z', 10);

        return time;
    }
}
