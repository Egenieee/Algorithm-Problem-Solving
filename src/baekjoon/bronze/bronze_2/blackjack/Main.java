package baekjoon.bronze.bronze_2.blackjack;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] cards = getCards(st);

        int minSum = getMinSum(cards, M);

        bw.write(String.valueOf(minSum));
        bw.flush();
        bw.close();
    }

    private static int[] getCards(StringTokenizer st) {
        int count = st.countTokens();
        int[] cards = new int[st.countTokens()];

        for (int i = 0 ; i < count ; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        return cards;
    }

    private static int getMinSum(int[] cards, int m) {
        int minDiff = Integer.MAX_VALUE;
        int minSum = 0;
        int sum;
        int tempDiff;
//        int one = 0;
//        int two = 0;
//        int three = 0;

        for (int i = 0 ;i < cards.length ; i++) {
            for (int j = i + 1 ; j < cards.length ; j++) {
                for (int k = j + 1 ; k < cards.length ; k++) {
                    sum = cards[i] + cards[j] + cards[k];
                    if (sum > m) {
                        continue;
                    }
                    tempDiff = m - sum;
                    if (tempDiff < minDiff) {
                        minDiff = tempDiff;
                        minSum = sum;
//                        one = i;
//                        two = j;
//                        three = k;
                    }
                }
            }
        }

//        System.out.println("first card : " + cards[one]);
//        System.out.println("second card : " + cards[two]);
//        System.out.println("third card : " + cards[three]);

        return minSum;
    }
}
