package backjoon.silver.silver_3.turret;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 두 원의 교점의 개수를 구하자

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int xOne = Integer.parseInt(st.nextToken());
            int yOne = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int xTwo = Integer.parseInt(st.nextToken());
            int yTwo = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int rOne = Math.max(r1, r2);
            int rTwo = Math.min(r1, r2);

            double d = Math.sqrt(Math.pow(xOne - xTwo, 2) + Math.pow(yOne - yTwo, 2));

            int meet = Integer.MAX_VALUE;

            if (d == 0 && rOne == rTwo) { // 두 원이 아예 똑같은 경우 d = 0 && r = r'
                meet = -1;
            }
            // 두 원이 안만나는 경우 r+r' < d , r-r' > d , d = 0 && r != r'
            else if ((rOne + rTwo < d) || (rOne - rTwo > d) || (d == 0 && rOne != rTwo)) {
                meet = 0;
            }
            // 한 점에서 만나는 경우 외접 r+r' == d , 내접 r-r' == d
            else if (rOne + rTwo == d || rOne - rTwo == d) {
                meet = 1;
            }
            // 두점에서 만나는 경우  r-r' < d < r+r'
            else if (rOne - rTwo < d && d < rOne + rTwo) {
                meet = 2;
            }

            bw.write(meet + "\n");
        }

        bw.flush();
        bw.close();
    }
}
