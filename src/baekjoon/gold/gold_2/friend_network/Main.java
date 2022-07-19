package baekjoon.gold.gold_2.friend_network;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int[] parents;
    public static int[] children;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int F = Integer.parseInt(br.readLine());

            parents = new int[F * 2];
            children = new int[F * 2];

            Map<String, Integer> network = new HashMap<>();

            int count = 0;

            // 자기 자신의 부모는 자신으로, 자식은 자기 하나로 초기화
            for (int k = 0; k < F * 2; k++) {
                parents[k] = k;
                children[k] = 1;
            }

            for (int j = 0; j < F; j++) {
                st = new StringTokenizer(br.readLine());

                String one = st.nextToken();
                String two = st.nextToken();

                if (!network.containsKey(one)) {
                    network.put(one, count);
                    count++;
                }

                if (!network.containsKey(two)) {
                    network.put(two, count);
                    count++;
                }

                union(network.get(one), network.get(two));

                int rootNum = parents[network.get(one)];
                int numberOfFriends = children[rootNum];
                bw.write(numberOfFriends + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
            children[x] += children[y];

            children[y] = 1;
        }
    }
}
