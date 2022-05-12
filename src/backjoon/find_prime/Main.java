package backjoon.find_prime;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int countOfPrime = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            if (isPrime(st.nextToken())) {
                countOfPrime++;
            }
        }

        bw.write(String.valueOf(countOfPrime));
        bw.flush();
        bw.close();
    }

    private static boolean isPrime(String num) {
        int number = Integer.parseInt(num);
        int divisor = 2;

        if (number <= 1) {
            return false;
        }

        while (divisor < number) {
            if (number % divisor == 0) {
                return false;
            }

            divisor++;
        }

        return true;
    }
}
