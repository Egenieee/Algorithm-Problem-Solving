package programmers.one_remainder;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(12));
    }
    public int solution(int n) {
        int answer = 0;

        int x = n - 1;

        for(int i = 0 ; i < n ; i++) {
            if(x == 0) break;
            if(n % x == 1) {
                answer = x;
                x--;
            } else {
                x--;
            }
        }

        return answer;
    }
}

// 나머지를 1로 만드는 가장 작은 수