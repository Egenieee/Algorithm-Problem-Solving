package backjoon.hansoo;

import java.io.*;

// 1 2 3 -> 한수
// 2 4 6 -> 한수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        int count = 0;

        for (int i = 1 ; i <= Integer.parseInt(N) ; i++) {
            if (isHansoo(String.valueOf(i))) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    public static boolean isHansoo(String number) {
        if (number.length() == 1) {
            return true;
        }

        int diff = (number.charAt(0) - '0') - (number.charAt(1) - '0');

        for (int i = 0 ; i < number.length() - 1 ; i++) {
            if (((number.charAt(i) - '0') - (number.charAt(i + 1) - '0')) != diff) {
                return false;
            }
        }

        return true;
    }
}
