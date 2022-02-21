package programmers.secret_map;

// 두 배열을 먼저 이진수로 바꾼 뒤에 and 연산을 한다. 그 결과를 #과 " "으로 치환하여 리턴하자.

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        // arr 1을 이진수로 바꾸자.
        for (int i = 0 ; i < n ; i++) {
            String str1 =Integer.toBinaryString(arr1[i]);
            String str2 = Integer.toBinaryString(arr2[i]);

            str1 = matchDigit(str1, n);
            str2 = matchDigit(str2, n);

            String result = andOperation(str1, str2);

            answer[i] = result;
            System.out.println(answer[i]);
        }

        return answer;
    }

    // 자릿수 n에 맞춰주는 메서드
    private String matchDigit(String str, int n) {
        StringBuilder stringBuilder = new StringBuilder(str);
        int numOfAdditionalNumber = n - str.length();
        if (str.length() != n) {
            for (int i = 0 ; i < numOfAdditionalNumber ; i++){
                stringBuilder.insert(0, "0");
            }
        }

        return stringBuilder.toString();
    }

    // 문자열 하나씩 비교해서 and 연산하자.
    // 두 숫자 비교한 결과 -> 이게 n번 반복되어야 함.
    private String andOperation(String str1, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < str1.length() ; i++) {
            int one = Integer.parseInt(String.valueOf(str1.charAt(i)));
            int two = Integer.parseInt(String.valueOf(str2.charAt(i)));

            int result = (one | two);

            stringBuilder.append(getAndWiseResult(result));
        }

        return stringBuilder.toString();
    }

    // bitwise 결과 1 == # or 0 == " " 반환해주는 함수
    private String getAndWiseResult(int result) {
        if(result == 1) {
            return "#";
        } else {
            return " ";
        }
    }

}
