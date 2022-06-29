package programmers.level_1.darts_game;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1D2S#10S"));
    }
    public int solution(String dartResult) {
        int totalScore;

        int[] scores = new int[3];
        String[] stringScores = getStringScores(dartResult);

        for (int i = 0 ; i < scores.length ; i++) {
            scores[i] = getOriginalScore(stringScores[i]);

            if (hasStarOrPound(stringScores[i])) {
                char option = stringScores[i].charAt(stringScores[i].length() - 1);

                if (i == 0) {
                    if (option == '*') {
                        scores[i] *= 2;
                    } else {
                        scores[i] *= -1;
                    }
                } else {
                    if (option == '*') {
                        scores[i] *= 2;
                        scores[i -1] *= 2;
                    } else {
                        scores[i] *= -1;
                    }
                }
            }

        }

        totalScore = Arrays.stream(scores).sum();

        return totalScore;
    }

    private String[] getStringScores(String dartResult) {
        int idx = 0;
        int splitStartIdx = 0;
        int splitEndIdx;

        String[] stringScores = new String[3];

        for (int i = 1 ; i < dartResult.length() ; i++) {
            if (dartResult.charAt(i) - '0' <= 10 && dartResult.charAt(i) - '0' >= 0) {
                if (idx == 2) {
                    stringScores[idx] = dartResult.substring(splitStartIdx);
                } else {
                    splitEndIdx = i;
                    stringScores[idx++] = dartResult.substring(splitStartIdx, splitEndIdx);
                    splitStartIdx = i;
                }
            }
        }

        return stringScores;
    }

    private int getOriginalScore(String stringScore) {
        int score = Integer.parseInt(stringScore.replaceAll("[^0-9]", ""));
        String bonus = stringScore.replaceAll("[^a-zA-Z]", "");

        if (bonus.equals("S")) {
            return (int) Math.pow(score, 1);
        }else if (bonus.equals("D")) {
            return (int) Math.pow(score, 2);
        }

        return (int) Math.pow(score, 3);
    }

    private boolean hasStarOrPound(String stringScore) {
        char lastLetter = stringScore.charAt(stringScore.length() - 1);
        return  lastLetter == '*' || lastLetter == '#';
    }

}
