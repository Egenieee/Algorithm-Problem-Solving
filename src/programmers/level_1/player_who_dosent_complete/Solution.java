package programmers.level_1.player_who_dosent_complete;

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

        // 선수와 선수의 완주 현황을 담을 맵
        HashMap<String, Integer > map = new HashMap<>();

        // 선수가 참가했으면 선수 이름과 1 담아줌
        for(String player : participant) {
            map.put(player, map.getOrDefault(player, 0) +1);
        }

        // 완주한 선수는 1을 빼줌 -> 0이 됨
        for(String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        // 0이 아닌 선수는 완주를 못했기 때문에 그 선수의 이름 반환
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
            }
        }
        return answer;
    }
}
