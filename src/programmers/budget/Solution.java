package programmers.budget;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {6,2,3,1,4}, 16));
    }
    public int solution(int[] d, int budget) {
        int answer = 0;
        int remainder = 0;

        Arrays.sort(d);

        for(int i = 0 ; i < d.length ; i++) {
            remainder += d[i];
            if(remainder > budget) {
                answer = i;
                break;
            }
        }

        if (remainder <= budget) {
            answer = d.length;
        }

        return answer;
    }
}
