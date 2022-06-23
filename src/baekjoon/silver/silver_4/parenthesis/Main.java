package baekjoon.silver.silver_4.parenthesis;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            bw.write(isValidParenthesis(br.readLine()) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static String isValidParenthesis(String parenthesis) {
        Stack<Character> checkParenthesis = new Stack<>();

        for (int i = 0 ; i < parenthesis.length() ; i++) {
            if (checkParenthesis.empty()) {
                checkParenthesis.push(parenthesis.charAt(i));
            } else {
                if (checkParenthesis.peek() == '(' && parenthesis.charAt(i) == ')') {
                    checkParenthesis.pop();
                } else {
                    checkParenthesis.push(parenthesis.charAt(i));
                }
            }
        }

        if (checkParenthesis.size() == 0) {
            return "YES";
        }

        return "NO";
    }
}
