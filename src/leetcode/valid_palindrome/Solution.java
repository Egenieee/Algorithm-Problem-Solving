package leetcode.valid_palindrome;

import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome("a");
    }
    public boolean isPalindrome(String s) {
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]"; //특수문자 확인
        s = s.replaceAll(match, ""); //특수문자 제거
        String cleanInputString = s.toLowerCase(Locale.ROOT); //소문자로 변환
        cleanInputString = cleanInputString.replaceAll(" ", ""); //스페이스 제거

        System.out.println(cleanInputString);
        char[] theArrayForCheck = cleanInputString.toCharArray();//char형 배열에 한 글자씩 담는다.

        int pointerOne = 0;
        int pointerTwo = cleanInputString.length() - 1; //맨 앞으로 가르키는 포인터와 맨 뒤를 가르키는 포인터를 생성한다.

        if(cleanInputString.length() == 0 ) return true; //빈 문자열이 들어왔을 경우 true반환으로 처리해준다.
        if(cleanInputString.length() % 2 != 0) { //스트링의 길이가 홀수인 경우
            while(pointerOne != pointerTwo) { //홀수일 경우에는 포인터1과 포인터2가 다를경우에만 반복하고 겹칠 경우엔 반복문에서 빠져나온다.
                if(theArrayForCheck[pointerOne] == theArrayForCheck[pointerTwo]) { //같으면 포인터 한칸씩 움직이기
                    pointerOne++;
                    pointerTwo--;
                } else {
                    return false;
                }
            }
            return true;
        } else { //스트링의 길이가 짝수인 경우. 포인터가 반까지만 가르키게하고 그 이상으론 가르키게하면 안된다.
            do { //우선 먼저 연산을 하고 조건을 확인해야 하기 때문에 do-while문을 사용한다.
                if(theArrayForCheck[pointerOne] == theArrayForCheck[pointerTwo]) {
                    pointerOne++;
                    pointerTwo--;
                } else {
                    return false;
                }
            } while (pointerOne != cleanInputString.length() / 2); //포인터가 스트링의 길이 반까지 연산 하게 한 후에 조건확인 후 반복문을 빠져나온다.

            return true;
        }

    }
}

//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
