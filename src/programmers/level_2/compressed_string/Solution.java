package programmers.level_3.compressed_string;

// 문자열을 k개 씩 자른다.
// 반복되는 문자열이 있으면 묶는다. (Map에 넣어볼까?)
// 각각 구해서 정리한 문자열의 길이를 비교한다.

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("ababababababababbbbbbbb");
        System.out.println(result);
    }
    public int solution(String s) {
        int bestResult = Integer.MAX_VALUE;

        if(s.length() == 1) {
            bestResult = 1;
            return bestResult;
        }

        for (int i = 3 ; i < s.length() ; i++) {
            String compressedString = getCompressedString(s, i);
            System.out.println(i + " : " + compressedString);
            int result = compressedString.length();

            if(result < bestResult) {
                bestResult = result;
            }
        }
        return bestResult;
    }

    private String getCompressedString(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();

        int len = s.length();
        int pointer = 0;

        String pattern = null;
        String newInput = s;

        Map<String, Integer> tempSaver = new HashMap<>();

        // aabb k = 2 aa
        // k 자리 만큼 잘라서 다음 k자리 만큼 같으면 맵에 추가 다르면 맵 정보 반영 후 맵 초기화
        while(pointer < len) {
            pattern = newInput.substring(0, k);
            newInput = newInput.substring(k);
            if(k > newInput.length()) {
                break;
            }
            String nextPattern = newInput.substring(0, k);

            if(pattern.equals(nextPattern)) {
                tempSaver.put(pattern, tempSaver.getOrDefault(pattern, 1) + 1);
            } else {
                if (tempSaver.containsKey(pattern) && tempSaver.get(pattern) != 1) {
                    stringBuilder.append(tempSaver.get(pattern));
                    stringBuilder.append(pattern);
                } else {
                    stringBuilder.append(pattern);
                }
                tempSaver.clear();
            }

            pointer += k;
        }

        if (tempSaver.containsKey(pattern) && tempSaver.get(pattern) != 1) {
            stringBuilder.append(tempSaver.get(pattern));
            stringBuilder.append(pattern);
        } else {
            stringBuilder.append(pattern);
        }

        stringBuilder.append(newInput);

        return stringBuilder.toString();
    }

}
