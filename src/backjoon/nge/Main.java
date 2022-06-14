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

        for (int i = 0 ; i < size ; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        String[] result = new String[stack.size()];

        int current = stack.pop();
        int previous = current;
        int max = current;
        int nge = -1;

        int resultIdx = stack.size();

        result[resultIdx--] = String.valueOf(nge);

        while (!stack.empty()) {
            current = stack.pop();
            if (current < previous) {
                nge = previous;
            } else if (current < max) {
                nge = max;
            } else if (current > max) {
                nge = -1;
                //max = current;
            }
            result[resultIdx--] = String.valueOf(nge);
            previous = current;
        }

        bw.write(String.join(" ", result));
        bw.flush();
        bw.close();
    }
}
