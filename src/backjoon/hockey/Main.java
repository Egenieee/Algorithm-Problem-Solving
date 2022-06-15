package backjoon.hockey;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public static class Link {
        int width;
        int height;
        int radius;

        Point standardPoint;
        Point firstCircleCenter;
        Point secondCircleCenter;

        public Link(int width, int height, int x, int y) {
            this.width = width;
            this.height = height;
            this.radius = height / 2;

            standardPoint = new Point(x, y);
            firstCircleCenter = new Point(x, y + (height/2));
            secondCircleCenter = new Point(x + width, y + (height/2));
        }

        public boolean isPlayerInLink(int playerX, int playerY) {
            // 첫번째 원 안에 들어오는 지 확인
            if (isInFirstCircle(playerX, playerY)) {
                return true;
            }
            // 첫번째 원에 안들어오면 직사각형 안에 들어가는 지 확인
            else if (isInRectangle(playerX, playerY)) {
                return true;
            }
            // 직사각형에도 안들어오면 두번째 원 안에 들어오는 지 확인
            else return isInSecondCircle(playerX, playerY);
        }

        private boolean isInFirstCircle(int playerX, int playerY) {
            return Math.pow(radius, 2) >= Math.pow(firstCircleCenter.getX() - playerX, 2) + Math.pow(firstCircleCenter.getY() - playerY, 2);
        }

        private boolean isInRectangle(int playerX, int playerY) {
            int x = standardPoint.getX();
            int y = standardPoint.getY();
            int limitX = x + width;
            int limitY = y + height;

            return (playerX >= x && playerX <= limitX && playerY >= y && playerY <= limitY);
        }

        private boolean isInSecondCircle(int playerX, int playerY) {
            return Math.pow(radius, 2) >= Math.pow(secondCircleCenter.getX() - playerX, 2) + Math.pow(secondCircleCenter.getY() - playerY, 2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // make a rink
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        Link link = new Link(width, height, x, y);

        int countOfPlayers = Integer.parseInt(st.nextToken());
        int countOfPlayersInRink = 0;

        // check if the player is in the rink
        for (int i = 0 ; i < countOfPlayers ; i++) {
            st = new StringTokenizer(br.readLine());
            int playerX = Integer.parseInt(st.nextToken());
            int playerY = Integer.parseInt(st.nextToken());

            if (link.isPlayerInLink(playerX, playerY)) {
                countOfPlayersInRink++;
            }
        }

        bw.write(String.valueOf(countOfPlayersInRink));
        bw.flush();
        bw.close();
    }
}
