package backjoon.the_little_prince;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T ; i++) {
            // for-loop 한번 -> test case 하나 처리
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int entryAndExit = 0;
            int countOfPlanet = Integer.parseInt(br.readLine());

            for (int j = 0 ; j < countOfPlanet ; j++) {
                st = new StringTokenizer(br.readLine());
                int centerX = Integer.parseInt(st.nextToken());
                int centerY = Integer.parseInt(st.nextToken());
                int radius = Integer.parseInt(st.nextToken());

                if (isInThePlanet(startX, startY, endX, endY, centerX, centerY, radius)) {
                    entryAndExit++;
                }
            }

            bw.write(entryAndExit + "\n");
        }

        bw.flush();
        bw.close();
    }

    // 원 안에 출발점이나 도착점이 존재한다면 카운트 증가.
    // 원 안에 출발점이나 도착점이 있고 다른 한 점은 원 밖에 있어야 한다. -> 이탈 안하고 도달가능하기 때문
    // 원 안에 있을 경우에만 진입/이탈해야하기 때문
    private static boolean isInThePlanet(int startX, int startY, int endX, int endY, int centerX, int centerY, int radius) {
        boolean startPointIsInThePlanet = (Math.pow(radius, 2) >= Math.pow(centerX - startX, 2) + Math.pow(centerY - startY, 2));
        boolean endPointIsInThePlanet = (Math.pow(radius, 2) >= Math.pow(centerX - endX, 2) + Math.pow(centerY - endY, 2));

        if (startPointIsInThePlanet && !endPointIsInThePlanet) {
            return true;
        }

        if(!startPointIsInThePlanet && endPointIsInThePlanet) {
            return true;
        }

        return false;
    }
}
