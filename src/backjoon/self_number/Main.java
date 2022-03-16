package backjoon.self_number;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Boolean> selfNumber = initMap();

        setSelfNumber(selfNumber);

        for (int self : selfNumber.keySet()) {
            if (!selfNumber.get(self)) {
                bw.write(self + "\n");
            }
        }

        bw.flush();
        bw.close();

    }

    private static Map<Integer, Boolean> initMap() {
        Map<Integer, Boolean> selfNumber = new LinkedHashMap<>();

        for (int i = 1; i < 10001 ; i++) {
            selfNumber.put(i, false);
        }

        return selfNumber;
    }

    private static void setSelfNumber(Map<Integer, Boolean> selfNumber) {
        for (int i = 1 ; i < 10001 ; i++) {
            int n = d(String.valueOf(i));
            selfNumber.put(n, true);
        }
    }

    private static int d(String number) {
        int result = 0;

        result += Integer.parseInt(number);

        for (int i = 0 ; i < number.length() ; i++) {
            result += Integer.parseInt(String.valueOf(number.charAt(i)));
        }

        return result;
    }
}
