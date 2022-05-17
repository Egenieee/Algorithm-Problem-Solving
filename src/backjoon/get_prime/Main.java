package backjoon.get_prime;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] primes = getPrimeArray(N);

        for (int i = 0 ; i <= N ; i++) {
            if (primes[i] == 0) {
                continue;
            }

            for (int j = i * 2 ; j <= N ; j += i) {
                primes[j] = 0;
            }
        }

        for (int i = M ; i <= N ; i++) {
            if (primes[i] != 0) {
                bw.write(primes[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static int[] getPrimeArray(int n) {
        int[] primes = new int[n + 1];

        for (int i = 2; i < primes.length ; i++) {
            primes[i] = i;
        }

        return primes;
    }
}
