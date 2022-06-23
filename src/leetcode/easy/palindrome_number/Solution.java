package leetcode.easy.palindrome_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome(-121);
    }
    public boolean isPalindrome(int x) {
        String xToString = Integer.toString(x); //문자열로 숫자 변환
        String[] inputNums = xToString.split(""); //문자열을 다시 문자열 배열로 변환

        if(inputNums[0].equals("-")) { //-로 시작하면 false 반환
            return false;
        }

        String[] reverseNums = new String[xToString.length()];

        int range = inputNums.length;
        int count = 0;

        for(int i = range - 1 ; i >= 0 ; i--) { //끝에서부터 하나씩 배열에 담음
            reverseNums[count] = inputNums[i];
            count++;
        }

//        System.out.println(Arrays.toString(inputNums));
//        System.out.println(Arrays.toString(reverseNums));

        String inputNum = String.join("", inputNums);
        String reverseNum = String.join("", reverseNums);

//        System.out.println("reverseNum = " + reverseNum);
//        System.out.println("inputNum = " + inputNum);

        if(inputNum.equals(reverseNum)){
            return true;
        }

        return false;
    }
}

//Input: x = 121
//Output: true

//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.