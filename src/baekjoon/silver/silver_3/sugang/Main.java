package baekjoon.silver.silver_3.sugang;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int limit = Integer.parseInt(st.nextToken());
        int numberOfClick = Integer.parseInt(st.nextToken());

        Set<String> suGang = new LinkedHashSet<>();

        for (int i = 0; i < numberOfClick; i++) {
            String id = br.readLine();
            suGang.remove(id);
            suGang.add(id);
        }

        int count = 0;

        for (String s : suGang) {
            bw.write(s + "\n");
            count++;
            if (count >= limit) {
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
