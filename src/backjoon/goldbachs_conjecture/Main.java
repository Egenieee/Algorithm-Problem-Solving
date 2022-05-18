package backjoon.goldbachs_conjecture;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Pair {
    private final int primeOne;
    private final int primeTwo;

    public Pair (int primeOne, int primeTwo) {
        this.primeOne = primeOne;
        this.primeTwo = primeTwo;
    }

    public int getPrimeDiff() {
        return Math.abs(primeOne - primeTwo);
    }

    public String getPrime() {
        int max = Math.max(primeOne, primeTwo);
        int min = Math.min(primeOne, primeTwo);

        return min + " " + max + "\n";
    }
}

public class Main {
    static class Validator {
        public static Pair getMinDiffPair(List<Pair> pairs) {
            if (pairs.size() == 1) {
                return pairs.get(0);
            }
            int minDiff = Integer.MAX_VALUE;
            Pair minDiffPair = null;

            for (Pair pair : pairs) {
                if (pair.getPrimeDiff() < minDiff) {
                    minDiff = pair.getPrimeDiff();
                    minDiffPair = pair;
                }
            }

            return minDiffPair;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> primeList = getPrimeArray();

        for (int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(br.readLine());

            List<Pair> answers = getPrimePair(primeList, n);

            Pair answerPrimePair = Validator.getMinDiffPair(answers);

            bw.write(answerPrimePair.getPrime());
        }

        bw.flush();
        bw.close();
    }

    private static List<Integer> getPrimeArray() {
        int[] primes = new int[10001];
        List<Integer> primeList = new ArrayList<>();

        for (int i = 2 ; i < primes.length ; i++) {
            primes[i] = i;
        }

        for (int j = 0 ; j < primes.length ; j++) {
            if (primes[j] == 0) {
                continue;
            }

            for (int k = j * 2 ; k < primes.length ; k += j) {
                primes[k] = 0;
            }
        }

        for (int prime : primes) {
            if (prime != 0) {
                primeList.add(prime);
            }
        }

        return primeList;
    }

    private static List<Pair> getPrimePair(List<Integer> primeList, int n) {
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0 ; i < primeList.size() ; i++) {
            if (primeList.get(i) >= n) {
                break;
            }
            for (int j = i ; j < primeList.size() ; j++) {
                if (primeList.get(j) >= n) {
                    break;
                }
                if (primeList.get(i) + primeList.get(j) == n) {
                    pairs.add(new Pair(primeList.get(i), primeList.get(j)));
                }
            }
        }

        return pairs;
    }
}
