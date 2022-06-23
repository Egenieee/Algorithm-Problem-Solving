package backjoon.silver.silver_4.stack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack stack = new Stack();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(String.valueOf(stack.pop()) + '\n');
                    break;
                case "size":
                    bw.write(String.valueOf(stack.size()) + '\n');
                    break;
                case "empty":
                    bw.write(String.valueOf(stack.empty()) + '\n');
                    break;
                default:
                    bw.write(String.valueOf(stack.top()) + '\n');
                    break;
            }
        }

        bw.flush();
        bw.close();
    }

    static class Stack {
        private final List<Integer> values;

        public Stack() {
            values = new ArrayList<>();
        }

        public void push(int value) {
            values.add(value);
        }

        public int pop() {
            if (values.size() == 0) {
                return -1;
            } else {
                int lastValue = values.get(values.size() - 1);
                values.remove(values.size() - 1);
                return lastValue;
            }
        }

        public int size() {
            return values.size();
        }

        public int empty() {
            if (values.size() == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        public int top() {
            if (values.size() == 0) {
                return -1;
            } else {
                return values.get(values.size() - 1);
            }
        }
    }
}