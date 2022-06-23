package backjoon.bronze.bronze_2.digit_generator;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int sum;
        int generator = 0;

        boolean hasGenerator = false;

        while (generator++ < N) {
            sum = generator;
            String generatorString = String.valueOf(generator);

            for (int i = 0 ; i < generatorString.length() ; i++) {
                sum += generatorString.charAt(i) - '0';
            }

            if (sum == N) {
                hasGenerator = true;
                bw.write(String.valueOf(generator));
                break;
            }
        }

        if (!hasGenerator) {
            bw.write(String.valueOf(0));
        }

        bw.flush();
        bw.close();

    }
}
