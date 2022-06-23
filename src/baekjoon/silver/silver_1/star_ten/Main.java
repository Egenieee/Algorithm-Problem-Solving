package baekjoon.silver.silver_1.star_ten;

import java.io.*;

// 핵심 아이디어 -> 배열을 사용하자

public class Main {
    static char[][] stars;
    private static final int PATTERN = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        stars = new char[N][N];

        getStar(0, 0, N, false);

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                bw.write(stars[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void getStar(int idxOfX, int idxOfY, int size, boolean isBlank) {
        // 공백을 찍어야 하는 경우
        if (isBlank) {
            for (int i = idxOfX ; i < idxOfX + size ; i++) {
                for (int j = idxOfY ; j < idxOfY + size ; j++) {
                    stars[i][j] = ' ';
                }
            }
            return;
        }

        // 가장 작은 블럭으로 쪼개졌을 경우
        if (size == 1) {
            stars[idxOfX][idxOfY] = '*';
            return;
        }

        // 더 작은 블록으로 쪼개야 하는 경우
        int countOfStars = 0;
        int blockSize = size/PATTERN;

        for (int i = idxOfX ; i < idxOfX + size ; i += blockSize) {
            for (int j = idxOfY ; j < idxOfY + size ; j += blockSize) {
                countOfStars++;
                getStar(i, j, blockSize, countOfStars == 5);
            }
        }

    }
}
