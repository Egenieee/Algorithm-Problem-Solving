package baekjoon.silver.silver_4.repaint_the_chessboard;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int minCount = Integer.MAX_VALUE;

        char[][] board = new char[row][column];
        char[][] blackStartBoard = getBlackBoard();
        char[][] whiteStartBoard = getWhiteBoard();

        for (int i = 0 ; i < row ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < column ; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 체스 판 잘라서 보기
        for (int i = 0 ; i <= row - 8 ; i++) {
            for (int j = 0 ; j <= column - 8 ; j++) {
                int count = getRepaintCount(i, j, board, blackStartBoard, whiteStartBoard);
                if (count < minCount) {
                    minCount = count;
                }
            }
        }

        bw.write(String.valueOf(minCount));
        bw.flush();
        bw.close();
    }

    // 8*8로 자른 하나의 체스판 확인 -> 칠해야 하는 개수 구하기
    // 블랙 버전과 화이트 버전 비교해서 더 적은 거 답으로 내기

    private static int getRepaintCount(int rowStart, int columnStart, char[][] board, char[][] blackStartBoard, char[][] whiteStartBoard) {
        int blackRepaint = getEachRepaintCount(rowStart, columnStart, board, blackStartBoard);
        int whiteRepaint = getEachRepaintCount(rowStart, columnStart, board, whiteStartBoard);

        return Math.min(blackRepaint, whiteRepaint);
    }

    private static int getEachRepaintCount(int rowStart, int columnStart, char[][] board, char[][] answerBoard) {
        int repaint = 0;

        for (int i = rowStart, answerRowIdx = 0; i < rowStart + 8 ; i++, answerRowIdx++) {
            for (int j = columnStart, answerColumnIdx = 0; j < columnStart + 8 ; j++, answerColumnIdx++) {
                if (answerBoard[answerRowIdx][answerColumnIdx] != board[i][j]) {
                    repaint++;
                }
            }
        }
        return repaint;
    }

    private static char[][] getBlackBoard() {
        char[][] answerBoard = new char[8][8];

        for (int i = 0 ; i < 8 ; i++) {
            for (int j = 0 ; j < 8 ; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        answerBoard[i][j] = 'B';
                    } else {
                        answerBoard[i][j] = 'W';
                    }
                } else {
                    if (j % 2 == 0) {
                        answerBoard[i][j] = 'W';
                    } else {
                        answerBoard[i][j] = 'B';
                    }
                }
            }
        }

        return answerBoard;
    }

    private static char[][] getWhiteBoard() {
        char[][] answerBoard = new char[8][8];

        for (int i = 0 ; i < 8 ; i++) {
            for (int j = 0 ; j < 8 ; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        answerBoard[i][j] = 'W';
                    } else {
                        answerBoard[i][j] = 'B';
                    }
                } else {
                    if (j % 2 == 0) {
                        answerBoard[i][j] = 'B';
                    } else {
                        answerBoard[i][j] = 'W';
                    }
                }
            }
        }

        return answerBoard;
    }
}
