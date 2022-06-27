package programmers.level_1.divisible_number_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{4, 3, 2, 6}, 2)));
    }
    public int[] solution(int[] arr, int divisor) {
        List<Integer> listForSort = new ArrayList<>();

        for (int num : arr) {
            if (num % divisor == 0) {
                listForSort.add(num);
            }
        }

        if (listForSort.size() == 0) {
            return new int[] {-1};
        }

        Collections.sort(listForSort);

        return listForSort.stream().mapToInt(i -> i).toArray();
    }
}
