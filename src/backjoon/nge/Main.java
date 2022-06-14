package backjoon.nge;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        //Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < size ; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

//        for (int i = 0 ; i < size ; i++) {
//            stack.push(Integer.parseInt(st.nextToken()));
//        }

        int nge;

        String[] result = new String[list.size()];

        for (int i = 0 ; i < size ; i++) {
            nge = getNGE(i, list);
            result[i] = String.valueOf(nge);
        }

//        int next = 0;
//        int current = stack.pop();
//        int previous = current;
//        int max = current;
//        int nge = -1;
//
//        int resultIdx = stack.size();
//
//        result[resultIdx--] = String.valueOf(nge);
//
//        while (!stack.empty()) {
//            current = stack.pop();
//            if (current < previous) {
//                nge = previous;
//            } else if (current > max) {
//                nge = -1;
//                max = current;
//            } else if (current < max && current > nge ) {
//                max = current;
//            }
////            else if (current < nge) {
////                nge = current;
////            }
//            result[resultIdx--] = String.valueOf(nge);
//            previous = current;
//        }

        bw.write(String.join(" ", result));
        bw.flush();
        bw.close();
    }

    private static int getNGE(int i, List<Integer> list) {
        int number = list.get(i);

        for (int idx = i ; idx < list.size() ; idx++) {
            if (list.get(idx) > number) {
                return list.get(idx);
            }
        }

        return -1;
    }
}
