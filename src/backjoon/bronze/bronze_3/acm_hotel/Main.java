package backjoon.bronze.bronze_3.acm_hotel;

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

            bw.write(getRoomNumber(floor, customerNumber) + "\n");
        }

        bw.flush();
        bw.close();

    }

    private static String getRoomNumber(int floor, int customerNumber) {
        // customerNumber / floor = 몫 ... 나머지
        // 몫 + 1 = 호수
        // 나머지 = 층

        int roomFloor = customerNumber % floor;
        int roomNumber = customerNumber/ floor;

        if (roomFloor == 0) {
            return String.valueOf(floor * 100 + roomNumber);
        }

        return String.valueOf(roomFloor * 100 + (roomNumber + 1));
    }
}
