package programmers.level_0.get_a_discount_on_a_clothing_store;

// 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인
// 100,000
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(580000));
    }

    public int solution(int price) {
        if (isOverFifty(price)) {
            return (int) (price * 0.8);
        }

        if (isOverThirty(price)) {
            return (int) (price * 0.9);
        }

        if (isOverTen(price)) {
            return (int) (price * 0.95);
        }

        return price;
    }

    private boolean isOverTen(int price) {
        return price >= 100000;
    }

    private boolean isOverThirty(int price) {
        return price >= 300000;
    }

    private boolean isOverFifty(int price) {
        return price >= 500000;
    }
}
