package baekjoon.bronze.bronze_3.oven_clock;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int FULL_MINUTE = 60;
    private static final int FULL_HOUR = 24;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String  before = br.readLine();
        int cost = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(before);

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        minute = minute + cost;

        if (minute >= FULL_MINUTE) {
            int addHour = minute / FULL_MINUTE;
            int addMinute = minute % FULL_MINUTE;

            hour += addHour;
            minute = addMinute;
        }

        if (hour >= FULL_HOUR) {
            hour -= FULL_HOUR;
        }

        bw.write(hour + " " + minute);
        bw.flush();
        bw.close();
    }
}
