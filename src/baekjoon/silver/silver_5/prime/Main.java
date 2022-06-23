package baekjoon.silver.silver_5.prime;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sumOfPrime = 0;
        int minPrime = Integer.MAX_VALUE;

        int count = 0;

        for (int i = M ; i <= N ; i++) {
            if (isPrime(i)) {
                sumOfPrime += i;
                count++;

                if (minPrime > i) {
                    minPrime = i;
                }
            }
        }

        if (count != 0) {
            bw.write(sumOfPrime + "\n" + minPrime);
        } else {
            bw.write(String.valueOf(-1));
        }
        bw.flush();
        bw.close();
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        int divisor = 2;

        while(divisor < number) {
            if (number % divisor == 0) {
                return false;
            }
            divisor++;
        }

        return true;
    }
}
