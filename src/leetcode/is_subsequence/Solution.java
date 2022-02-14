package leetcode.is_subsequence;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isSubsequence("ab", "accccccccccb");
    }
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true; //s가 아무것도 없는 문자열이라면 t에 무엇이오든지 true이다.

        int patternPointer = 0; //s의 문자를 하나씩 가르킬 포인터
        int targetPointer = 0; //t의 문자를 하나씩 가르킬 포인터
        int matchCount = 0; //두 포인터가 가르키고 있는 문자가 맞다면 카운터 1 증가

        while (patternPointer < s.length() && targetPointer < t.length()) { //반복문의 조건은 s와 t의 범위 내에서만 포인터가 움직여야 한다.
            if(s.charAt(patternPointer) == t.charAt(targetPointer)) { //두 포인터가 가르키는 문자가 서로 일치하면
                matchCount++; //매치카운터 증가
                patternPointer++; //두 포인터 1씩 증가
                targetPointer++;
            } else { // 다르면
                targetPointer++; //t를 가르키고 있는 포인터만 1 증가
            }
        }

        if(matchCount >= s.length()) { //반복문을 다 돈 후에 match한 개수가 s의 길이와 같으면 return true
            return true;
        } else {
            return false;
        }
    }
}
