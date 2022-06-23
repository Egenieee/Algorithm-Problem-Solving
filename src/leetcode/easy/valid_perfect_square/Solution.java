package leetcode.easy.valid_perfect_square;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPerfectSquare(25);
    }
    public boolean isPerfectSquare(int num) {
        if(num < 2) {
            return true;
        }
        long start = 1;
        long end = num / 2;

        while(start <= end) {
            long mid = start + (end - start)/2; //start와 end의 중간값을 찾는다.
            if(mid*mid == num) { //중간값끼리 곱했을때 num이면 return true
                return true;
            }
            if(mid*mid < num) { //중간값끼리 곱했을때 num보다 작으면 start를 중간값 뒤로 설정하고 다시 탐색하게 한다.
                start = mid + 1;
            } else { //중간값끼리 곱했을때 num보다 작으면 end값을 중간값 앞으로 설정하고 다시 탐색하게 한다.
                end = mid - 1;
            }
        }

        return false;
    }
}
