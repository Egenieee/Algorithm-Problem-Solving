package backjoon.large_number_sum;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        bw.write(getSum(A, B));
        bw.flush();
        bw.close();
    }

    private static String getSum(String a, String b) {
        int pointA = a.length() - 1;
        int pointB = b.length() - 1;
        int add;
        int carry = 0;

        StringBuilder stringBuilder = new StringBuilder();

        while(pointA >= 0 || pointB >= 0) {
            add = carry;

            if (pointA >= 0) {
                add += a.charAt(pointA) - '0';
            }

            if (pointB >= 0) {
                add += b.charAt(pointB) - '0';
            }

            if (add > 9) {
                carry = 1;
                add -= 10;
            } else {
                carry = 0;
            }

            stringBuilder.append(add);

            pointA--;
            pointB--;
        }

        if (carry != 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }

}
