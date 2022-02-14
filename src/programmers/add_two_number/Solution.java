package programmers.add_two_number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{2,1,3,4,1});
    }
    public int[] solution(int[] numbers) {
        Set<Integer> answers = new HashSet<>();

        for(int i = 0 ; i < numbers.length ; i++){
            for (int j = i + 1 ; j < numbers.length ; j++){
                int sum = numbers[i] + numbers[j];
                answers.add(sum);
            }
        }

        Integer[] answerInteger = answers.toArray(new Integer[0]);
        Arrays.sort(answerInteger);

        int[] answer = new int[answerInteger.length];

        for(int i = 0 ; i < answer.length ; i ++) {
            answer[i] = answerInteger[i];
        }

        return answer;
    }
}
