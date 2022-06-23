package leetcode.easy.most_common_word;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.mostCommonWord("Ball.     HIt, Bob", new String[]{"hit", "bob"});
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] inputParagraph = getInputParagraphData(paragraph); //가공한 input data 받기
        Map<String, Integer> map = getInputMap(inputParagraph); //가공한 input data를 map자료구조에 담기

        if (banned != null) { //금지된 단어 지우기
            removeBannedWord(map, banned);
        }

        String answer = calculateCommonWord(map); //금지된 단어 제외 가장 빈도가 많은 단어 반환

        return answer;
    }

    private String[] getInputParagraphData(String paragraph) { //받은 input data 가공하기
        paragraph = paragraph.replaceAll("[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]", " ").toLowerCase(Locale.ROOT); //특수문자 공백으로 치환하고 소문자로 변환

        String[] inputStrArray = paragraph.split("\\s+"); //공백(공백 크기가 어떻든) 기준으로 잘라서 string 배열에 단어마다 다 옮겨 담기

        return inputStrArray;
    }

    private Map<String, Integer> getInputMap(String[] inputStrArray) { //map에 담기
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < inputStrArray.length; i++) { //담을 때마다 value 값을 1씩 추가해서 넣는다.
            map.put(inputStrArray[i], map.getOrDefault(inputStrArray[i], 0) + 1);
        }

        return map;
    }

    private void removeBannedWord(Map<String, Integer> map, String[] banned) {//banned 단어 삭제하기
        for (String word : banned) {
            map.remove(word);
        }
    }

    private String calculateCommonWord(Map<String, Integer> map) { //map에서 가장 value가 큰 key 반환
//        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
//                return e1.getValue().compareTo(e2.getValue());
//            }
//        }; 아래와 같이 생략가능

        Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue(); //comparator 사용해서 value값이 가장 큰 map의 키 반환

        Map.Entry<String, Integer> maxEntry = Collections.max(map.entrySet(), comparator);

        return maxEntry.getKey();

    }
}
