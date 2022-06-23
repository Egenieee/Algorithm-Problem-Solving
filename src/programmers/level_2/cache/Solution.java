package programmers.level_2.cache;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(0, new String[] {"Jeju", "jeju"}));
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int cycles = 0;

        Map<String, Integer> caches = new HashMap<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toLowerCase(Locale.ROOT);
            // 캐쉬 하나씩 뒤지자
            if (caches.containsKey(city)) { // 캐시에 있으면 hit
                caches.put(city, cycles); // 참조한 시간만 다시 put
                answer += 1;
            } else {
                // 캐시가 비었을 경우
                if (caches.size() < cacheSize && !caches.containsKey(city)) {
                    caches.put(city, cycles);
                    answer += 5;
                } else { // 캐시가 꽉 찼는데 없을 경우
                    // 가장 예전에 참조 됐던 시간 구하는 함수
                    String lruKey = getRLU(caches);
                    // 가장 예전에 참조 됐던 도시 이름 삭제
                    caches.remove(lruKey);
                    // 그 자리에 다시 put
                    caches.put(city, cycles);
                    answer += 5;
                }
            }
            cycles++;
        }

        return answer;
    }

    private String getRLU(Map<String, Integer> caches) {
        int lru = Integer.MAX_VALUE;
        String lruKey = "";
        for (String city : caches.keySet()) {
            if (caches.get(city) < lru) {
                lru = caches.get(city);
                lruKey = city;
            }
        }
        return lruKey;
    }
}
