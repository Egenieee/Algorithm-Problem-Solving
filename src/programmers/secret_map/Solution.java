package programmers.secret_map;

// 두 배열을 먼저 이진수로 바꾼 뒤에 and 연산을 한다. 그 결과를 #과 " "으로 치환하여 리턴하자.

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        // arr 1을 이진수로 바꾸자.
        for (int i = 0 ; i < n ; i++) {
            StringBuilder str1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder str2 = new StringBuilder(Integer.toBinaryString(arr2[i]));

            matchDigit(str1, n);
            matchDigit(str2, n);

            System.out.println(str1.toString());
            System.out.println(str2.toString());
        }



        return answer;
    }

    // 자릿수 n에 맞춰주는 메서드
    private void matchDigit(StringBuilder str, int n) {
        int numOfAdditionalNumber = n - str.length();
        if (str.length() != n) {
            for (int i = 0 ; i < numOfAdditionalNumber ; i++){
                str.insert(0, "0");
            }
        }
    }

    // 문자열 하나씩 비교해서 and 연산하자.
    private List<String> andOperation(String str1, String str2) {
        for (int i = 0 ; i < str1.length() ; i++) {
            int one = Integer.parseInt(String.valueOf(str1.charAt(i)));
            int two = Integer.parseInt(String.valueOf(str2.charAt(i)));

            int
        }
    }

}
