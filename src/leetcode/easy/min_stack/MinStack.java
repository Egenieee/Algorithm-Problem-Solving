package leetcode.easy.min_stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinStack {

    List<Integer> minStack = new ArrayList<>();

    public MinStack() {}

    public void push(int val) {
        minStack.add(val);
    }

    public void pop() {
        minStack.remove(minStack.size() - 1);
    }

    public int top() {
        return minStack.get(minStack.size() - 1);
    }

    public int getMin() {
        return Collections.min(minStack);
    }
}

