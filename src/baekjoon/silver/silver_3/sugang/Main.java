package baekjoon.silver.silver_3.sugang;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int limit = Integer.parseInt(st.nextToken());
        int numberOfClick = Integer.parseInt(st.nextToken());

        Map<String, Integer> suGang = new HashMap<>();

        for (int i = 0; i < numberOfClick; i++) {
            suGang.put(br.readLine(), i);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(suGang.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        for (int i = 0; i < limit; i++) {
            bw.write(entryList.get(i).getKey() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
