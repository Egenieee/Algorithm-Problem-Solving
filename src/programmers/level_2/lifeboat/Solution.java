package programmers.level_2.lifeboat;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{90, 80, 70, 40, 60, 30, 30, 20}, 100));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int minWeightIndex = 0;
        int maxWeightIndex = people.length - 1;

        while (minWeightIndex <= maxWeightIndex) {
            if (people[minWeightIndex] + people[maxWeightIndex] <= limit) {
                minWeightIndex++;
                maxWeightIndex--;
                answer++;
            } else {
                maxWeightIndex--;
                answer++;
            }
        }

        return answer;
    }
}
