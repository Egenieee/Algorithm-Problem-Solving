package baekjoon.bronze.bronze_1.im_gonna_be_bunyeohoejang;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < testCaseCount ; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int countOfPeople = getCountOfPeople(k,n);

            bw.write(String.valueOf(countOfPeople) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int getCountOfPeople(int k, int n) {
        int[][] houses = getHouses();

        return houses[k][n - 1];
    }

    private static int[][] getHouses() {
        int[][] houses = new int[15][15];

        for (int i = 0 ; i < houses.length ; i++) {
            houses[0][i] = i + 1;
            houses[i][0] = 1;
        }

        for (int i = 1 ; i < houses.length ; i++) {
            for (int j = 1 ; j < houses.length ; j++) {
                houses[i][j] = houses[i - 1][j] + houses[i][j - 1];
            }
        }

        return houses;
    }

}
