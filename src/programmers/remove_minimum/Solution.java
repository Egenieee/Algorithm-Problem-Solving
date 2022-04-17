package programmers.remove_minimum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{4,3,2,1}));
    }

    public List<Integer> solution(int[] arr) {
        int min = getMinNum(arr);

        return getAnswer(min, arr);
    }

    private int getMinNum(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            if (min > num) {
                min = num;
            }
        }

        return min;
    }

    private List<Integer> getAnswer(int min, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int num : arr) {
            if (num != min) {
                answer.add(num);
            }
        }

        if (answer.size() == 0) {
            answer.add(-1);
        }

        return answer;
    }

}
