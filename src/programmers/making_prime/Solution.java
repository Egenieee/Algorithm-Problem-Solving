package programmers.making_prime;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1,2,3,4}));
    }

    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0 ; i < nums.length ; i ++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int sum) {
        int divisor = 2;
        boolean prime = true;
        while (sum > divisor) {
            if(sum % divisor == 0) {
                prime = false;
            }
            divisor++;
        }

        return prime;
    }
}
