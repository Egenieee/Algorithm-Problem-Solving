package programmers.level_two.tuple;

// input : "{{2},{2,1},{2,1,3},{2,1,3,4}}"
// output : [2,1,3,4]

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
    }
    public List<Integer> solution(String s) {
        // 중괄호 제거
        s = s.replaceAll("\\{", " ");
        s = s.replaceAll("\\}", " ");
        s = s.replaceAll(" ", "");
        // System.out.println(s);

        // 숫자 배열에 하나씩 담기
        String[] strings = s.split(",");

        List<Integer> nums = new ArrayList<>();

        for (String str : strings) {
            nums.add(Integer.parseInt(str));
        }
         // hashmap으로 빈도수 체크
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) +1);
        }

        // hashmap에서 value 기준으로 내림차순 정렬
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(numMap.entrySet());

        sortedList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        // 정렬한 순서대로 값 새로운 list에 담기
        List<Integer> answer = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : sortedList) {
            answer.add(entry.getKey());
        }

        return answer;
    }
}
