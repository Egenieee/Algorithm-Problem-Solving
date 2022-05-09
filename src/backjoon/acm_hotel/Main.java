package backjoon.acm_hotel;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < testCaseCount ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int floor = Integer.parseInt(st.nextToken());
            int roomCount = Integer.parseInt(st.nextToken());
            int customerNumber = Integer.parseInt(st.nextToken());

            String[][] hotel = getHotel(floor, roomCount);

            bw.write(getRoomNumber(hotel, floor, customerNumber) + "\n");
        }

        bw.flush();
        bw.close();

    }

    private static String[][] getHotel(int floor, int roomCount) {
        String[][] hotel = new String[floor + 1][roomCount + 1];

        for (int i = 0 ; i < floor + 1 ; i++) {
            for (int j = 0 ; j < roomCount + 1 ; j++) {
                if (j + 1 < 10) {
                    hotel[i][j] = (i + 1) + "0" + (j + 1);
                } else {
                    hotel[i][j] = i + 1 + String.valueOf(j + 1);
                }
            }
        }

        return hotel;
    }

    private static String getRoomNumber(String[][] hotel, int floor, int customerNumber) {
        // customerNumber / floor = 몫 ... 나머지
        // 몫 + 1 = 호수
        // 나머지 = 층

        int roomFloor = customerNumber % floor;
        int roomNumber = customerNumber/ floor;

        if (roomFloor == 0) {
            return hotel[floor - 1][roomNumber - 1];
        }

        return hotel[roomFloor - 1][roomNumber];
    }
}
