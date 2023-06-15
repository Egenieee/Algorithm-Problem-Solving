package programmers.level_2.find_the_largest_number_behind;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{9, 1, 5, 3, 6, 2})));
    }

    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            // 스택이 비어있지 않고, 스택의 맨 위 요소가 현재 보고 있는 요소 보다 작을 때 -> 뒤에 있는 큰 수 !
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            // 현재 보고 있는 숫자의 인덱스 넣기
            stack.push(i);
        }

        // stack 안에 있는 인덱스들은 뒤에 있는 큰 수를 못 찾은 수이므로, -1로 설정한다.
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
