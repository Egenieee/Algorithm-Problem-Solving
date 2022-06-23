package leetcode.easy.bianry_number_with_alternating_bits;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.hasAlternatingBits(10);
    }
    public boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString( n ); //입력받은 숫자를 이진수로 변환한다.

        for(int i = 0 ; i < str.length() - 1 ; i++) { //스트링 길이 - 1 만큼 순회한다
            if(str.charAt(i) == str.charAt(i + 1)) { //현재 인덱스와 다음 인덱스가 같은 지 판단한다.
                return false; //같으면 퐁당퐁당이 안되기 때문에 return false
            }
        }

        //조건문에 안걸리고 반복문 다 돌면 return true
        return true;
    }
}
