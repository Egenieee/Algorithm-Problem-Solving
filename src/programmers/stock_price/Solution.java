package programmers.stock_price;

// input : [1, 2, 3, 2, 3]	, output : [4, 3, 1, 1, 0]
// 각 초 대의 주식 가격이 몇 초간 가격이 떨어지지 않았는 지 배열에 담아서 리턴
//

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new int[] {1, 2, 3, 2, 1});
        System.out.println(Arrays.toString(result));
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int count;

        for (int i = 0 ; i < prices.length ; i++) {
            // 몇 초 버티는 지 기록할 변수 count
            count = 0;
            // 몇 초의 주식 가격을 기록할 변수 current
            int current = prices[i];

            for (int j = i + 1 ; j < prices.length ; j++) {
                // 일단 버티는 초 증가
                count++;
                // 현재 보고있는 초의 가격보다 떨어지면 반복문 빠져 나온 후
                if (current > prices[j]) {
                    break;
                }
            }
            // 얼마나 버텼는 지 기록
            answer[i] = count;
        }

        return answer;
    }
}
