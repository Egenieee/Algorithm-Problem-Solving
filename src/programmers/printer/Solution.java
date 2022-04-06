package programmers.printer;

// priorities [2, 1, 3, 2] location 2 return 1
// 확인 -> 뒤로 넘기거나, -> 프린트하거나

// <0, 2> <1, 1> <2, 3> <3, 2> -> pair 이용
// <2, 3> <3, 2> <0, 2> <1, 1>

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    static class Pair {
        private final int index;
        private final int priority;

        Pair(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        public int getIndex() {
            return index;
        }

        public int getPriority() {
            return priority;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location) {
        int answer;

        // enqueue
        Deque<Pair> docs = getDocsQueue(priorities);
        List<Pair> printOrder = new ArrayList<>();

        // get importance
        int importance;

        while (!docs.isEmpty()) {
            importance = getImportance(docs);

            Pair pair = docs.pop();

            int doc = pair.getPriority();
            // check

            if (doc < importance) {
                docs.add(pair);
            } else {
                printOrder.add(pair);
            }
        }

        answer = getAnswer(printOrder, location);

        return answer;
    }

    private Deque<Pair> getDocsQueue(int[] priorities) {
        Deque<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            Pair pair = new Pair(i, priorities[i]);
            queue.add(pair);
        }

        return queue;
    }


    private int getImportance(Deque<Pair> prioritiesPairs) {
        int max = Integer.MIN_VALUE;

        for (Pair pair : prioritiesPairs) {
            int priority = pair.getPriority();
            if (priority > max) {
                max = priority;
            }
        }

        return max;
    }

    private int getAnswer(List<Pair> printOrder, int location) {
        for (int i = 0; i < printOrder.size(); i++) {
            Pair pair = printOrder.get(i);

            if (pair.getIndex() == location) {
                return i + 1;
            }
        }

        return -1;
    }
}
