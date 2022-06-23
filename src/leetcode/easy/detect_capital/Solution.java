package leetcode.easy.detect_capital;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.detectCapitalUse("abc");
    }
    public boolean detectCapitalUse(String word) {
        if(detectOnlyFirstCapitalUse(word)) {
            return true;
        } else if(detectAllCapitalUse(word)) {
            return true;
        } else if(detectNotCapitalUse(word)) {
            return true;
        }
        return false;
    }

    public boolean detectOnlyFirstCapitalUse(String word) {//앞 글자 하나만 대문자일 경우
        char charactor;
        int count = 0;

        charactor = word.charAt(count);
        if(Character.isLowerCase(charactor)) {//첫 글자가 소문자면 바로 false 반환.
            return false;
        } else {
            count = 1;
            while(count < word.length()) {
                charactor = word.charAt(count);
                if(Character.isLowerCase(charactor)) {
                    count++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean detectAllCapitalUse(String word) { //문자가 모두 대문자로 이루어져 있을 경우
        char charactor;
        int count = 0;
        while(count < word.length()) {
            charactor = word.charAt(count);
            if(Character.isUpperCase(charactor)) {
                count++;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean detectNotCapitalUse(String word) {//문자가 모두 소문자로만 이루어져 있을 경우
        char charactor;
        int count = 0;
        while(count < word.length()) {
            charactor = word.charAt(count);
            if(Character.isLowerCase(charactor)) {
                count++;
            } else {
                return false;
            }
        }

        return true;
    }
}

//모두 대문자로 된 스트링이거나, 소문자로만 이루어진 스트링이거나, 맨 앞글자만 대문자인 스트링일 경우에만 true반환하기.
