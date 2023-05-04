package baekjoon.bronze.bronze_1.average;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfSubjects = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] subjects = new int[numberOfSubjects];

        for (int i = 0; i < numberOfSubjects; i++) {
            subjects[i] = Integer.parseInt(st.nextToken());
        }

        int maxScore = getMaxScore(subjects);

        bw.write(String.valueOf(getNewAverage(maxScore, subjects)));
        bw.flush();
        bw.close();
    }

    private static int getMaxScore(int[] subjects) {
        int max = Integer.MIN_VALUE;

        for (int score : subjects) {
            if (score > max) {
                max = score;
            }
        }

        return max;
    }

    private static double getNewAverage(int maxScore, int[] subjects) {
        double sum = 0;

        for (int score : subjects) {
            double newScore = (double) score / maxScore * 100;
            sum += newScore;
        }

        return sum / subjects.length;
    }
}
