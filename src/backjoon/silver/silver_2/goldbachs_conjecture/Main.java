package backjoon.silver.silver_2.goldbachs_conjecture;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[] primes = getPrimeArray();

        for (int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(br.readLine());

            String answer = getAnswer(primes, n);

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static String getAnswer(boolean[] primes, int n) {
        int primeOne = n / 2;
        int primeTwo = n / 2;

        while (primeTwo > 0) {
            if (primes[primeOne] && primes[primeTwo]) {
                return primeTwo + " " + primeOne;
            }

            primeOne++;
            primeTwo--;
        }

        return "0";
    }

    private static boolean[] getPrimeArray() {
        boolean[] primes = new boolean[10001];

        for (int i = 2 ; i < primes.length ; i++) {
            primes[i] = true;
        }

        for (int j = 0 ; j < primes.length ; j++) {
            if (!primes[j]) {
                continue;
            }

            for (int k = j * 2 ; k < primes.length ; k += j) {
                primes[k] = false;
            }
        }

        return primes;
    }
}
