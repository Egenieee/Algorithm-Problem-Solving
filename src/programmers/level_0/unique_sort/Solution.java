package programmers.level_0.unique_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{10000, 20, 36, 47, 40, 6, 10, 7000}, 30)));
    }

    public int[] solution(int[] numlist, int n) {
        List<Integer> numbers = new ArrayList<>();

        // n과의 차이값 저장
        for (int number : numlist) {
            numbers.add(number - n);
        }

        // 차이값으로 정렬
        numbers.sort((numberOne, numberTwo) -> {
            if (Math.abs(numberOne) == Math.abs(numberTwo)) {
                return numberTwo.compareTo(numberOne); // 차이의 절댓값이 같으면 더 큰 수가 먼저오도록 내림차순
            }

            return Math.abs(numberOne) - Math.abs(numberTwo);
        });

        int[] answer = new int[numlist.length];

        // 원래대로 값 복구
        for (int i = 0; i < numbers.size(); i++) {
            answer[i] = numbers.get(i) + n;
        }

        return answer;
    }
}
