package backjoon.symmetric_difference_set;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> setA = new ArrayList<>();
        List<Integer> setB = new ArrayList<>();

        for (int i = 0 ; i < A ; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < B ; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> checkA = new ArrayList<>(setA);
        List<Integer> checkB = new ArrayList<>(setB);

        int diffA = setA.size();
        int diffB = setB.size();

        setA.retainAll(setB);
        checkB.retainAll(checkA);

        diffA -= setA.size();
        diffB -= checkB.size();

        bw.write(String.valueOf(diffA + diffB));
        bw.flush();
        bw.close();
    }
}
