package programmers.create_a_minimum;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }
    public int solution(int []A, int []B) {
        int answer = 0;
        int twoIdx = B.length - 1;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0 ; i < A.length ; i++) {
            answer += A[i] * B[twoIdx];
            twoIdx--;
        }

        return answer;
    }
}
