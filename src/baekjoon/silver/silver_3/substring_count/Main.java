package baekjoon.silver.silver_3.substring_count;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        Set<String> subStrings = new HashSet<>();

        for (int cutSize = 1 ; cutSize <= S.length() ; cutSize++) {
            saveSubStrings(S, cutSize, subStrings);
        }

        bw.write(String.valueOf(subStrings.size()));
        bw.flush();
        bw.close();
    }

    private static void saveSubStrings(String S, int cutSize, Set<String> substrings) {
        int loopCount = (S.length() + 1) - cutSize;

        for (int startIdx = 0 ; startIdx < loopCount ; startIdx++) {
            substrings.add(S.substring(startIdx, startIdx + cutSize));
        }
    }
}
