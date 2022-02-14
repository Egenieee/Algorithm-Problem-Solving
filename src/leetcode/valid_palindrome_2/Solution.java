package leetcode.valid_palindrome_2;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.validPalindrome("temmed");
    }
    public boolean validPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        while(leftPointer < rightPointer) {
            if(s.charAt(leftPointer) == s.charAt(rightPointer)) { //끝에서부터 비교하면서 두 포인터가 가르치는 글자가 같으면 한칸씩 옮김
                leftPointer++;
                rightPointer--;
                continue;
            } else { // 두 포인터가 가르키는 글자가 다를 경우
                if(leftPointer + 1 == rightPointer || rightPointer - 1 == leftPointer) {
                    return true;
                } //eebe와 같은 경우 처리하기 위한 조건문 1 + 1 = 2 즉, leftPointer + 1 = rightPointer 성립된다

                //eebebe같은 경우 2~4다(beb)까지 확인시키고 1~3(ebe)까지 확인 시킨다
                boolean checkOne = checkValidPalindromeWithPartOfString(leftPointer + 1 , rightPointer , s);
                boolean checkTwo = checkValidPalindromeWithPartOfString(leftPointer, rightPointer - 1, s);

                return (checkOne || checkTwo); //둘 중 하나만 true이면 return true
            }
        }

        return true;
    }

    private boolean checkValidPalindromeWithPartOfString(int left, int right, String s) {
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right --;
            } else { //여기서 두 글자가 다르면 바로 false 반환
                return false;
            }
        }
        return true;
    }

}
