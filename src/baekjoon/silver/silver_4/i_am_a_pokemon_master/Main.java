package baekjoon.silver.silver_4.i_am_a_pokemon_master;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> pokemonBookWithNumber = new HashMap<>();
        Map<String, Integer> pokemonBookWithName = new HashMap<>();

        for (int i = 1 ; i <= N ; i++) {
            String name = br.readLine();
            pokemonBookWithNumber.put(i, name);
            pokemonBookWithName.put(name, i);
        }

        for (int i = 0 ; i < M ; i++) {
            String command = br.readLine();
            if (pokemonBookWithName.containsKey(command)) {
                bw.write(pokemonBookWithName.get(command) + "\n");
            } else {
                bw.write(pokemonBookWithNumber.get(Integer.parseInt(command)) + "\n");
            }
        }

        bw.flush();
        bw.close();

    }
}
