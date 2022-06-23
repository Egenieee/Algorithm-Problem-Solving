package baekjoon.gold.gold_4.nge;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int[] numbers = new int[size];

        for (int i = 0 ; i < size ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // stack 안에 있는 값은 바뀌어야 할 인덱스
        // 현재 보고 있는 값과 스택의 맨 위에 있는 값을 비교해서 현재 값이 더 크면, 오큰수가 되기 때문에
        // 스택에서 팝하고 그 인덱스에 현재 보고 있는 값을 오큰수로 할당한다.
        for (int currentIdx = 0 ; currentIdx < size ; currentIdx++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[currentIdx]) {
                numbers[stack.pop()] = numbers[currentIdx];
            }

            stack.push(currentIdx);
        }

        // stack 에 남아있는 인덱스는 오큰수를 찾지 못했다는 뜻이 되므로 다 -1로 바꿔준다.

        while (!stack.isEmpty()) {
            numbers[stack.pop()] = -1;
        }

        for (int number : numbers) {
            sb.append(number).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
