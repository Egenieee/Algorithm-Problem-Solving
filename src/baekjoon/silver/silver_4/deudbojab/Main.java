package baekjoon.silver.silver_4.deudbojab;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        Set<String> people = new HashSet<>();
        List<String> deudbojob = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            people.add(br.readLine());
        }

        for (int i = 0 ; i < M ; i++) {
            String name = br.readLine();
            if (people.contains(name)) {
                count++;
                deudbojob.add(name);
            }
        }

        Collections.sort(deudbojob);

        bw.write(count + "\n" + String.join("\n", deudbojob));
        bw.flush();
        bw.close();
    }
}
