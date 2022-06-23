package programmers.calculate_ride_price;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 20, 4));
    }
    public long solution(int price, int money, int count) {
        long answer;

        answer = sumOfPrice(price, count);

        if (answer <= money) {
            return 0;
        }

        answer -= money;

        return answer;
    }

    private long sumOfPrice(int price, int count) {
        long sum = 0;
        for (int i = 1 ; i <= count ; i++) {
            sum += (price * (long)i);
        }
        return sum;
    }
}
