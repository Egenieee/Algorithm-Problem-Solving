package leetcode.easy.check_if_n_and_its_double_exist;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.checkIfExist(new int[] {3,2,5,10});
    }
    public boolean checkIfExist(int[] arr) {
        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = i + 1 ; j < arr.length ; j++) {
                if(arr[i] == 2 * arr[j]) { //각 i와 j가 가르키고 있는 숫자중 j가 가르키고 있는 수를 2배해서 i과 같은지 판별한다.
                    return true; //같으면 return ture
                } else if (arr[j] == 2 * arr[i]) { //각 i와 j가 가르키고 있는 숫자중 i가 가르키고 있는 수를 2배해서 j과 같은지 판별한다.
                    return true; //같으면 return ture
                }
            }
        }

        return false; // return true로 빠지는 것 없이 반복문 빠져나오면 return false
    }
}

//Input: arr = [10,2,5,3]
//Output: true
//Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.

//i != j
//0 <= i, j < arr.length
//arr[i] == 2 * arr[j]