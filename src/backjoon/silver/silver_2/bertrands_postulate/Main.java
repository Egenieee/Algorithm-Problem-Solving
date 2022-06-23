package backjoon.silver.silver_2.bertrands_postulate;

// 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int[] primes = getPrimeArray(n);

            for (int i = 0 ; i <= 2 * n ; i++) {
                if (primes[i] == 0) {
                    continue;
                }

                for (int j = i * 2 ; j <= 2 * n ; j += i) {
                    primes[j] = 0;
                }
            }

            int countOfPrime = getCountOfPrime(primes, n);

            bw.write(countOfPrime + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int[] getPrimeArray(int n) {
        int[] primes = new int[2*n + 1];

        for (int i = 2 ; i <= 2 * n ; i++) {
            primes[i] = i;
        }

        return primes;
    }

    private static int getCountOfPrime(int[] primes, int n) {
        int countOfPrime = 0;

        for (int i = n + 1 ; i <= n * 2 ; i++) {
            if (primes[i] != 0) {
                countOfPrime++;
            }
        }

        return countOfPrime;
    }
}
