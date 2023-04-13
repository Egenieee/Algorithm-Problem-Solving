package programmers.level_2.news_clustering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("ABC", "EFG"));
    }

    public int solution(String str1, String str2) {
        String one = getLowerCase(str1);
        String two = getLowerCase(str2);

        List<String> setOne = getSet(one);
        List<String> setTwo = getSet(two);

        Map<String, Integer> setOneMap = getMap(setOne);
        Map<String, Integer> setTwoMap = getMap(setTwo);

        int unionSize = getUnionSize(setOneMap, setTwoMap);
        int intersectionSize = getIntersectionSize(setOneMap, setTwoMap);

        double similarity = getSimilarity(unionSize, intersectionSize);

        return (int) (similarity * 65536);
    }

    private String getLowerCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(Character.toLowerCase(str.charAt(i)));
        }

        return stringBuilder.toString();
    }

    private List<String> getSet(String string) {
        List<String> stringSet = new ArrayList<>();

        for (int i = 0; i < string.length() - 1; i++) {
            String piece = string.substring(i, i + 2);

            if (isValidSet(piece)) {
                stringSet.add(piece);
            }
        }

        return stringSet;
    }

    private boolean isValidSet(String piece) {
        for (int i = 0; i < piece.length(); i++) {
            if (!Character.isAlphabetic(piece.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private Map<String, Integer> getMap(List<String> set) {
        Map<String, Integer> map = new HashMap<>();

        for (String element : set) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        return map;
    }

    private int getUnionSize(Map<String, Integer> setOneMap, Map<String, Integer> setTwoMap) {
        int unionSize = 0;

        Map<String, Integer> oneMap = new HashMap<>(setOneMap);
        Map<String, Integer> twoMap = new HashMap<>(setTwoMap);

        for (String key : oneMap.keySet()) {
            if (twoMap.containsKey(key)) {
                unionSize += Math.max(oneMap.get(key), twoMap.get(key));
                twoMap.remove(key);
                continue;
            }

            unionSize += oneMap.get(key);
        }

        for (String key : twoMap.keySet()) {
            unionSize += twoMap.get(key);
        }

        return unionSize;
    }

    private int getIntersectionSize(Map<String, Integer> setOneMap, Map<String, Integer> setTwoMap) {
        int intersectionSize = 0;

        Map<String, Integer> oneMap = new HashMap<>(setOneMap);
        Map<String, Integer> twoMap = new HashMap<>(setTwoMap);

        for (String key : oneMap.keySet()) {
            if (twoMap.containsKey(key)) {
                intersectionSize += Math.min(oneMap.get(key), twoMap.get(key));
                twoMap.remove(key);
            }
        }

        return intersectionSize;
    }

    private double getSimilarity(int unionSize, int intersectionSize) {
        if (unionSize == 0 && intersectionSize == 0) {
            return 1;
        }

        return (double) intersectionSize / unionSize;
    }
}
