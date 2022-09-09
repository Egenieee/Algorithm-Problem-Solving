package programmers.level_1.personality_type_test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int SCORE_STANDARD = 4;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }

    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> scoreTable = initScore();

        for (int i = 0; i < survey.length; i++) {
            doTest(scoreTable, survey[i], choices[i]);
        }

        return getFinalType(scoreTable);
    }

    private Map<String, Integer> initScore() {
        Map<String, Integer> score = new HashMap<>();

        score.put("R", 0);
        score.put("T", 0);
        score.put("C", 0);
        score.put("F", 0);
        score.put("J", 0);
        score.put("M", 0);
        score.put("A", 0);
        score.put("N", 0);

        return score;
    }

    private void doTest(Map<String, Integer> scoreTable, String survey, int choice) {
        String firstIndicator = survey.substring(0, 1); // 첫번째 지표
        String secondIndicator = survey.substring(1); // 두번째 지표

        int score;

        if (choice < SCORE_STANDARD) {
            score = -(choice - SCORE_STANDARD);
            scoreTable.put(firstIndicator, score);
        } else {
            score = choice - SCORE_STANDARD;
            scoreTable.put(secondIndicator, score);
        }
    }


    private String getFinalType(Map<String, Integer> scoreTable) {
        String type = "";

        type += getEachType(scoreTable, "R", "T");
        type += getEachType(scoreTable, "C", "F");
        type += getEachType(scoreTable, "J", "M");
        type += getEachType(scoreTable, "A", "N");

        return type;
    }

    private String getEachType(Map<String, Integer> scoreTable, String first, String second) {
        int firstScore = scoreTable.get(first);
        int secondScore = scoreTable.get(second);

        if (firstScore > secondScore) {
            return first;
        } else if (firstScore < secondScore) {
            return second;
        } else {
            return compareString(first, second);
        }
    }

    private String compareString(String first, String second) {
        int compare = first.compareTo(second);

        if (compare > 0) { // first가 second 뒤에 오는 경우
            return second;
        }

        return first; // first가 second 앞에 오는 경우
    }
}
