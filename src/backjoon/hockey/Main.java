package backjoon.hockey;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 일단 링크장 만들자
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int countOfPlayers = Integer.parseInt(st.nextToken());
        int countOfPlayersInLink = 0;

        // 선수 좌표 받아서 링크장 안에 있는 지 판단하자
        for (int i = 0 ; i < countOfPlayers ; i++) {
            st = new StringTokenizer(br.readLine());
            int playerX = Integer.parseInt(st.nextToken());
            int playerY = Integer.parseInt(st.nextToken());

            if (isPlayerInLink(width, height, x, y, playerX, playerY)) {
                countOfPlayersInLink++;
            }
        }
    }

    private static boolean isPlayerInLink(int width, int height, int x, int y, int playerX, int playerY) {
        return true;
    }
}
