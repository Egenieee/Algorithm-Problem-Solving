package programmers.player_who_dosent_complete;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
    public String solution(String[] participant, String[] completion) {
        String answer = null;

        HashMap<String, Integer > map = new HashMap<>();

        for(String player : participant) {
            map.put(player, map.getOrDefault(player, 0) +1);
        }

        for(String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
            }
        }
        return answer;
    }
}
