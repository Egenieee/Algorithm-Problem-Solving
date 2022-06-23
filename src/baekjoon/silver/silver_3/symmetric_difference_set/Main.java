package baekjoon.silver.silver_3.symmetric_difference_set;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int i = 0 ; i < A ; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < B ; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> setAForSub = new HashSet<>(setA);
        Set<Integer> setBForSub = new HashSet<>(setB);

        setAForSub.removeAll(setB);
        setBForSub.removeAll(setA);

        bw.write(String.valueOf(setAForSub.size() + setBForSub.size()));
        bw.flush();
        bw.close();
    }
}
