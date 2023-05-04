package baekjoon.bronze.bronze_3.alarm_clock;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int ALARM_MINUTE = 45;
    private static final int FULL_HOUR = 24;
    private static final int FULL_MINUTE = 60;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int originalHour = Integer.parseInt(st.nextToken());
        int originalMinute = Integer.parseInt(st.nextToken());

        int alarmHour = originalHour;
        int alarmMinute = originalMinute - ALARM_MINUTE;

        if (alarmMinute < 0) {
            alarmMinute += FULL_MINUTE;
            alarmHour = originalHour - 1;
        }

        if (alarmHour < 0) {
            alarmHour = FULL_HOUR - 1;
        }

        bw.write(alarmHour + " " + alarmMinute);
        bw.flush();
        bw.close();
    }
}
