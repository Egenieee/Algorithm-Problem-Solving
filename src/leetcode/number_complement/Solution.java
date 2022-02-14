package leetcode.number_complement;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findComplement(1);
    }
    public int findComplement(int num) {
        String binaryNum = Integer.toBinaryString(num); //주어진 십진수를 이진수로 변환한다
        StringBuilder complementNum = new StringBuilder(); //스트링빌더를 이용해 반대 이진수를 만든다.

        for(int i = 0 ; i < binaryNum.length() ; i++) { //주어진 수의 이진수 길이만큼 돌면서 1 -> 0 으로, 0 -> 1로 바꿔 스트링빌더에 저장한다.
            if(binaryNum.charAt(i) == '1') {
                complementNum.append("0");
            } else {
                complementNum.append("1");
            }
        }

        String result = complementNum.toString(); //스트링빌더를 문자열로 변환한 뒤,

        return Integer.parseInt(result, 2); //결과를 다시 십진수로 변환하여 return한다.

    }
}
