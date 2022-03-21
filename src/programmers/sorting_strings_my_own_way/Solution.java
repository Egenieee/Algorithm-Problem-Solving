package programmers.sorting_strings_my_own_way;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"car", "send", "son", "aaaa"}, 1));
    }
    public List<String> solution(String[] strings, int n) {
        List<String> answer = new ArrayList<>();

        // 인덱스 n을 value로 정리한 map 얻기
        Map<String, Integer> words = getWords(strings, n);

        // Map.Entry 리스트 작성
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<Map.Entry<String, Integer>>(words.entrySet());

        // n(value)을 기준으로 정렬하기
        sortMyOwnWay(sortedWords);

        for(Map.Entry<String, Integer> entry : sortedWords) {
            answer.add(entry.getKey());
        }

        return answer;
    }
    private Map<String, Integer> getWords(String[] strings, int n) {
        Map<String, Integer> words = new HashMap<>();

        for (String word : strings) {
            words.put(word, (int) word.charAt(n) - 97);
        }

        return words;
    }
    private void sortMyOwnWay(List<Map.Entry<String, Integer>> sortedWords) {
        // 비교함수 Comparator를 사용하여 오름차순으로 정렬
        sortedWords.sort(new Comparator<Map.Entry<String, Integer>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                // 만약 value 값이 같을 경우 key 값으로 비교해서 정렬
                if (obj1.getValue().equals(obj2.getValue())) {
                    return obj1.getKey().compareTo(obj2.getKey());
                }
                return obj1.getValue().compareTo(obj2.getValue());
            }
        });
    }
}
