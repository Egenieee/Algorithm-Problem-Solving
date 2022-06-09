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
        List<Integer> sorted = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            String coordinate = st.nextToken();
            originCoordinates.add(Integer.parseInt(coordinate));
            sorted.add(Integer.parseInt(coordinate));
        }

        Collections.sort(sorted);

        Map<Integer, Integer> orderMap = new HashMap<>();

        int order = 0;

        for (int coordinate : sorted) {
            if (!orderMap.containsKey(coordinate)) {
                orderMap.put(coordinate, order);
                order++;
            }
        }

        List<String> compressedCoordinates = new ArrayList<>();

        for (int coordinate : originCoordinates) {
            int compressed = orderMap.get(coordinate);
            compressedCoordinates.add(String.valueOf(compressed));
        }

        bw.write(String.join(" ", compressedCoordinates));
        bw.flush();
        bw.close();
    }
}
