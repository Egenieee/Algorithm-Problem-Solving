package etc.ss_sw_algorithm.no_6;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            List<String> linkedList = new LinkedList<>();

            int N = Integer.parseInt(sc.nextLine());
            st = new StringTokenizer(sc.nextLine());

            for (int i = 0; i < N; i++) {
                linkedList.add(st.nextToken());
            }

            int commandCount = Integer.parseInt(sc.nextLine());
            st = new StringTokenizer(sc.nextLine());

            for (int j = 0; j < commandCount; j++) {
                String command = st.nextToken();
                if (command.equals("I")) {
                    insert(linkedList, st);
                } else if (command.equals("D")) {
                    delete(linkedList, st);
                } else {
                    append(linkedList, st);
                }
            }

            System.out.print("#" + test_case + " ");

            for (int k = 0; k < 10; k++) {
                System.out.print(linkedList.get(k) + " ");
            }

            System.out.println();
        }
    }

    private static void insert(List<String> linkedList, StringTokenizer st) {
        int idx = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            linkedList.add(idx, st.nextToken());
            idx++;
        }
    }

    private static void delete(List<String> linkedList, StringTokenizer st) {
        int idx = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            linkedList.remove(idx);
        }
    }

    private static void append(List<String> linkedList, StringTokenizer st) {
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            linkedList.add(st.nextToken());
        }
    }
}


