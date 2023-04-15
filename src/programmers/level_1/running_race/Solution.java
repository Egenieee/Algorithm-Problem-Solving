package programmers.level_1.running_race;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine", "soe"})));
    }

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = getPlayerRank(players);

        for (String calling : callings) {
            int rankToChange = rank.get(calling);
            rank.put(calling, rankToChange - 1);

            String slowPlayer = players[rankToChange - 1];
            rank.put(slowPlayer, rankToChange);

            // swap position
            players[rankToChange] = slowPlayer;
            players[rankToChange - 1] = calling;
        }

        return players;
    }

    private Map<String, Integer> getPlayerRank(String[] players) {
        Map<String, Integer> rank = new HashMap<>();
        int rankOrder = 0;

        for (String player : players) {
            rank.put(player, rankOrder++);
        }

        return rank;
    }
}
