package backjoon.coordinates_compression;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        List<Integer> originCoordinates = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            originCoordinates.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> removeDuplicated = new HashSet<>(originCoordinates);
        List<Integer> sorted = new ArrayList<>(removeDuplicated);
        Collections.sort(sorted);

        Map<Integer, Integer> order = new HashMap<>();

        for (int i = 0 ; i < sorted.size() ; i++) {
            order.put(sorted.get(i), i);
        }

        List<String> compressedCoordinates = new ArrayList<>();

        for (int coordinate : originCoordinates) {
            int compressed = order.get(coordinate);
            compressedCoordinates.add(String.valueOf(compressed));
        }

        bw.write(String.join(" ", compressedCoordinates));
        bw.flush();
        bw.close();
    }
}
