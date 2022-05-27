package backjoon.repaint_the_chessboard;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        char[][] board = new char[row][column];

        for (int i = 0 ; i < row ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < column ; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int minCount = Integer.MAX_VALUE;

        // 체스 판 잘라서 보기
        for (int i = 0 ; i <= row - 8 ; i++) {
            for (int j = 0 ; j <= column - 8 ; j++) {
                //System.out.println("row : " + i + ", column : " + j);
                int count = checkBoard(i, j, board);
                //System.out.println("count : " + count);
                if (count < minCount) {
                    minCount = count;
                }
                //System.out.println();
            }
        }

        bw.write(String.valueOf(minCount));
        bw.flush();
        bw.close();
    }

    // 8*8로 자른 하나의 체스판 확인 -> 칠해야 하는 개수 구하기
    private static int checkBoard(int rowStart, int columnStart, char[][] board) {

        char lastColor = board[rowStart + 7][columnStart + 7];

        //System.out.println("lastColor : " + lastColor);

        if (lastColor == 'B') {
            return blackFirstBoard(rowStart, columnStart, board);
        }

        return whiteFirstBoard(rowStart, columnStart, board);
    }

    private static int blackFirstBoard(int rowStart, int columnStart, char[][] board) {
        int repaint = 0;

        for (int i = rowStart, rowIdx = 0 ; i < rowStart + 8 ; i++, rowIdx++) {
            int count = 0;
            for (int j = columnStart, columnIdx = 0 ; j < columnStart + 8 ; j++, columnIdx++) {
                //System.out.print(board[i][j]);
                if (rowIdx % 2 == 0 && columnIdx % 2 == 0) {
                    if (board[i][j] != 'B') {
                        count++;
                    }
                } else if (rowIdx % 2 == 0 && columnIdx % 2 == 1) {
                    if (board[i][j] != 'W') {
                        count++;
                    }
                } else if (rowIdx % 2 == 1 && columnIdx % 2 == 0) {
                    if (board[i][j] != 'W') {
                        count++;
                    }
                } else if (rowIdx % 2 == 1 && columnIdx % 2 == 1) {
                    if (board[i][j] != 'B') {
                        count++;
                    }
                }
            }
            //System.out.print(" " + count);
            repaint += count;
            //System.out.println();
        }

        return repaint;
    }

    private static int whiteFirstBoard(int rowStart, int columnStart, char[][] board) {
        int repaint = 0;

        for (int i = rowStart, rowIdx = 0 ; i < rowStart + 8 ; i++, rowIdx++) {
            int count = 0;
            for (int j = columnStart, columnIdx = 0 ; j < columnStart + 8 ; j++, columnIdx++) {
                //System.out.print(board[i][j]);
                if (rowIdx % 2 == 0 && columnIdx % 2 == 0) {
                    if (board[i][j] != 'W') {
                        count++;
                    }
                } else if (rowIdx % 2 == 0 && columnIdx % 2 == 1) {
                    if (board[i][j] != 'B') {
                        count++;
                    }
                } else if (rowIdx % 2 == 1 && columnIdx % 2 == 0) {
                    if (board[i][j] != 'B') {
                        count++;
                    }
                } else if (rowIdx % 2 == 1 && columnIdx % 2 == 1) {
                    if (board[i][j] != 'W') {
                        count++;
                    }
                }
            }
            //System.out.print(" " + count);
            repaint += count;
            //System.out.println();
        }

        return repaint;
    }
}
