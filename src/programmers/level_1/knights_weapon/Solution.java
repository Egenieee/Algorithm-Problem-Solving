package programmers.level_1.knights_weapon;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 3, 2));
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int divisor = getDivisorCount(i);

            if (divisor > limit) {
                answer += power;
            } else {
                answer += divisor;
            }
        }

        return answer;
    }

    private int getDivisorCount(int number) {
        int count = 0;

        for (int i = 1; i * i <= number; i++) {
            // 제곱근이면 카운트 1
            if (i * i == number) {
                count++;
            }

            // 나눠지면 반대의 수도 약수가 될 수 있으므로 카운트 2
            else if (number % i == 0) {
                count += 2;
            }
        }

        return count;
    }
}
