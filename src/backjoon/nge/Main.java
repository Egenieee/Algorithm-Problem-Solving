package backjoon.nge;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();

        for (int i = 0 ; i < size ; i++) {
            int number = Integer.parseInt(st.nextToken());

            stack.push(number);
        }

        int current = stack.pop();
        int previous = current;
        int max = current;
        int nge = -1;

        result.push(nge);

        while (!stack.empty()) {
            current = stack.pop();
            if (current < previous) {
                max = previous;
            } else if (current > max) {
                max = -1;
            }
            nge = max;
            result.push(nge);
            previous = current;
        }
    }
}
