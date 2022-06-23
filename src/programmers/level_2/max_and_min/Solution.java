package programmers.level_2.max_and_min;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("-1 -2 -3 -4"));
    }

    public String solution(String s) {
        List<Integer> numbers = getNumbers(s);

        int max = getMaxNumber(numbers);
        int min = getMinNumber(numbers);

        return max + " " + min;
    }

    private List<Integer> getNumbers(String s) {
        String[] number = s.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String num : number) {
            numbers.add(Integer.parseInt(num));
        }

        return numbers;
    }

    private int getMaxNumber(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;

        for (int num : numbers) {
            if (min > num) {
                min = num;
            }
        }

        return min;
    }

    private int getMinNumber(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (max < num) {
                max = num;
            }
        }

        return max;
    }
}
