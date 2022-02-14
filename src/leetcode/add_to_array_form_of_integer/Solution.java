package leetcode.add_to_array_form_of_integer;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addToArrayForm(new int[] {9,9,9}, 1);
    }
    public List<Integer> addToArrayForm(int[] num, int k) {
        String arrayFormNum = arrayToString(num); //num을 String으로 변환
        String kNum = String.valueOf(k); //k도 String으로 변환

        String addTwoNum = addTwoString(arrayFormNum, kNum); //두 스트링을 숫자처럼 더하는 함수

        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < addTwoNum.length() ; i++) { //리스트에 담아준다
            result.add(addTwoNum.charAt(i) - '0');
        }

        return result;
    }

    private String addTwoString(String one, String two) {
        StringBuilder stringBuilder = new StringBuilder();

        int idxOfOne = one.length() - 1;
        int idxOfTwo = two.length() - 1;

        int carryOver = 0;

        while(idxOfOne >= 0 || idxOfTwo >= 0) {
            int value = carryOver;
            if(idxOfOne >= 0) {
                value += one.charAt(idxOfOne--) - '0';
            }
            if(idxOfTwo >= 0) {
                value += two.charAt(idxOfTwo--) - '0';
            }

            if(value > 9) {
                carryOver = 1;
                value -= 10;
                stringBuilder.append(value);
            } else {
                carryOver = 0;
                stringBuilder.append(value);
            }
        }

        if(carryOver > 0) {
            stringBuilder.append(carryOver);
        }

        return stringBuilder.reverse().toString();
    }

    private String arrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int num : array) {
            stringBuilder.append(num);
        }

        return stringBuilder.toString();
    }
}

//Input: num = [1,2,0,0], k = 34
//Output: [1,2,3,4]
//Explanation: 1200 + 34 = 1234
