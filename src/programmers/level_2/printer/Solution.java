package programmers.level_2.printer;

// priorities [2, 1, 3, 2] location 2 return 1
// 확인 -> 뒤로 넘기거나, -> 프린트하거나

// <0, 2> <1, 1> <2, 3> <3, 2> -> pair 이용해서 인덱스와 중요도 함께 저장. (Deque 이용)
// <2, 3> <3, 2> <0, 2> <1, 1> -> pair 이용해서 프린트하는 순서 저장. (List 이용)

import java.util.*;
import java.util.stream.IntStream;

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
        int maxImportance;

        while (!docs.isEmpty()) {
            maxImportance = getImportance(docs);

            Pair doc = docs.pop();

            if (doc.getPriority() < maxImportance) {
                docs.add(doc);
            } else {
                printOrder.add(doc);
            }
        }

        answer = getOrder(printOrder, location);

        return answer;
    }

    private Deque<Pair> getDocsQueue(int[] priorities) {
        Deque<Pair> queue = new ArrayDeque<>();
        IntStream.range(0, priorities.length)
                .forEach(i -> queue.add(new Pair(i, priorities[i])));

        return queue;
    }


    private int getImportance(Deque<Pair> prioritiesPairs) {
        Pair maxPriorityPair = prioritiesPairs
                .stream()
                .max(Comparator.comparing(Pair::getPriority))
                .orElseThrow(NoSuchElementException::new);

        return maxPriorityPair.getPriority();
    }

    private int getOrder(List<Pair> printOrder, int location) {
        for (int i = 0; i < printOrder.size(); i++) {
            Pair pair = printOrder.get(i);

            if (pair.getIndex() == location) {
                return i + 1;
            }
        }

        return -1;
    }
}
