package programmers.level_1.memory_score;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"},
                        {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}})));
    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int order = 0;

        Map<String, Integer> memoryScoreTable = getMemoryScoreTable(name, yearning);

        for (String[] eachPhoto : photo) {
            for (String person : eachPhoto) {
                if (memoryScoreTable.containsKey(person)) {
                    answer[order] += memoryScoreTable.get(person);
                }
            }

            order++;
        }

        return answer;
    }

    private Map<String, Integer> getMemoryScoreTable(String[] name, int[] yearning) {
        Map<String, Integer> memoryScoreTable = new HashMap<>();

        for (int i = 0; i < yearning.length; i++) {
            memoryScoreTable.put(name[i], yearning[i]);
        }

        return memoryScoreTable;
    }
}
