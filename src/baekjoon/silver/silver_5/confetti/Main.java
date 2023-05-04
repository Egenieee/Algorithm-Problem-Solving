package baekjoon.silver.silver_5.confetti;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int numberOfPaper = Integer.parseInt(br.readLine());
        int[][] board = new int[100][100];

        for (int i = 0; i < numberOfPaper; i++) {
            st = new StringTokenizer(br.readLine());

            int xStart = Integer.parseInt(st.nextToken());
            int yStart = Integer.parseInt(st.nextToken());

            fillBoard(board, xStart, yStart);
        }

        bw.write(String.valueOf(getAreaSize(board)));
        bw.flush();
        bw.close();
    }

    private static void fillBoard(int[][] board, int xStart, int yStart) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[xStart + i][yStart + j] == 0) {
                    board[xStart + i][yStart + j] = 1;
                }
            }
        }
    }

    private static int getAreaSize(int[][] board) {
        int count = 0;

        for (int[] ints : board) {
            for (int i = 0; i < board.length; i++) {
                if (ints[i] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
