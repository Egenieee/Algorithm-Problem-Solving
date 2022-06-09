package backjoon.number_card;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int cardCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Set<Integer> cards = new HashSet<>();

        for (int i = 0 ; i < cardCount ; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int checkCardCount = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < checkCardCount ; i++) {
            int card = Integer.parseInt(st.nextToken());

            if (cards.contains(card)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
