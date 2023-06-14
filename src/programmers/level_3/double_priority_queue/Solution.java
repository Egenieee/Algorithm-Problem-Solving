package programmers.level_3.double_priority_queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    private static final String INSERT = "I";
    private static final String DELETE = "D";

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333", "D 1", "I 123"})));
    }

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        Queue<Integer> priorityQueueWithMin = new PriorityQueue<>();
        Queue<Integer> priorityQueueWithMax = new PriorityQueue<>(Collections.reverseOrder());

        for (String command : operations) {
            String[] commands = command.split(" ");

            if (isEmptyQueue(priorityQueueWithMin, priorityQueueWithMax)) {
                priorityQueueWithMin.clear();
                priorityQueueWithMax.clear();
            }

            if (commands[0].equals(INSERT)) {
                priorityQueueWithMin.add(Integer.parseInt(commands[1]));
                priorityQueueWithMax.add(Integer.parseInt(commands[1]));
            }

            if (commands[0].equals(DELETE) && !isEmptyQueue(priorityQueueWithMin, priorityQueueWithMax) && commands[1].equals("-1")) {
                priorityQueueWithMin.poll();
            }

            if (commands[0].equals(DELETE) && !isEmptyQueue(priorityQueueWithMin, priorityQueueWithMax) && commands[1].equals("1")) {
                priorityQueueWithMax.poll();
            }
        }

        if (isEmptyQueue(priorityQueueWithMin, priorityQueueWithMax)) {
            return new int[]{0, 0};
        }

        priorityQueueWithMax.retainAll(priorityQueueWithMin);

        answer[0] = priorityQueueWithMax.peek();
        answer[1] = priorityQueueWithMin.peek();

        return answer;
    }

    private boolean isEmptyQueue(Queue<Integer> min, Queue<Integer> max) {
        Queue<Integer> minPriority = new PriorityQueue<>(min);
        Queue<Integer> maxPriority = new PriorityQueue<>(max);

        minPriority.retainAll(maxPriority);

        return minPriority.size() == 0;
    }
}
