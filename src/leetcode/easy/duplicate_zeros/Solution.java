package leetcode.easy.duplicate_zeros;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.duplicateZeros(new int[] {1,0,2,3,0,4,5,0});
    }
    public void duplicateZeros(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder(); //스트링 빌더를 이용하자
        int arrLenCount = 0;

        while (stringBuilder.length() < arr.length) { //스트링빌더의 길이까지만 반복문 실행
            if(arr[arrLenCount] == 0) { //0이면 해당 인덱스를 일단 스트링빌더로 붙인후, 0을 한 번 더 붙인다.
                stringBuilder.append(arr[arrLenCount]);
                stringBuilder.append(0);
            } else { //0이 아닐경우 해당 인덱스만 스트링 빌더로 붙인다.
                stringBuilder.append(arr[arrLenCount]);
            }
            arrLenCount++;
        }

        String afterModifying = stringBuilder.toString(); //스트링 빌더를 스트링변수로 변환한다.

        for(int i = 0 ; i < arr.length ; i++) { //스트링 변수를 하나씩 숫자로 변환해 배열에 다시 담는다.
            arr[i] = afterModifying.charAt(i) - '0';
        }
    }
}

//Input: arr = [1,0,2,3,0,4,5,0]
//Output: [1,0,0,2,3,0,0,4]
//Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
