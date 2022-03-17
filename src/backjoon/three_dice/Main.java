package backjoon.three_dice;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        int three = Integer.parseInt(st.nextToken());

        int reward = 0;

        if(isAllDifferent(one, two, three)) {
            reward = maxDice(one, two, three) * 100;
        }

        if (isTwoEqual(one, two, three)) {
            reward = 1000 + equalDice(one, two, three) * 100;
        }

        // 모두 같은 경우
        if (isAllEqual(one, two, three)) {
            reward = 10000 + equalDice(one, two, three) * 1000;
        }

        bw.write(String.valueOf(reward));
        bw.flush();
        bw.close();
    }

    private static boolean isAllDifferent(int one, int two, int three) {
        return (one != two) && (two != three)  && (one != three);
    }

    private static boolean isTwoEqual(int one, int two, int three) {
        return ((one == two) || (two == three)  || (one == three)) && !isAllEqual(one, two, three);
    }

    private static boolean isAllEqual(int one, int two, int three) {
        return (one == two) && (two == three) && (one == three);
    }

    private static int maxDice(int one, int two, int three) {
        if (one >= two && one >= three) {
            return one;
        }

        if (two > one && two >= three) {
            return two;
        }

        return three;
    }

    private static int equalDice(int one, int two, int three) {
        if (one == two) {
            return one;
        }

        return three;
    }
}
