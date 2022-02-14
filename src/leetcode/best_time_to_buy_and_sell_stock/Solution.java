package leetcode.best_time_to_buy_and_sell_stock;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(new int[] {7,1,5,3,6,4});
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrices = Integer.MAX_VALUE; //최소값 찾기위해 초기화.

        for(int i = 0 ; i < prices.length ; i++) {
            if(prices[i] < minPrices) { //최소값보다 현재 값이 작으면
                minPrices = prices[i]; //최소갑에 현재 값 담기
            } else {
                int diff = prices[i] - minPrices; //현재값에서 최소값 빼서 차익 계산
                if(profit < diff) { //새로 계산한 차익이 기존 차익보다 크면
                    profit = diff; //새로 계산한 차익이 기존 차익 대체
                }
            }
        }

        return profit; //가장 큰 차익 반환.
    }
}
