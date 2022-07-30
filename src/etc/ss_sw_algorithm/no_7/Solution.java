package etc.ss_sw_algorithm.no_7;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        StringTokenizer st;

        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(sc.nextLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(sc.nextLine());
            List<String> linkedList = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                linkedList.add(st.nextToken());
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(sc.nextLine());

                edit(linkedList, st);
            }

            String query;

            if (L > linkedList.size() - 1) {
                query = "-1";
            } else {
                query = linkedList.get(L);
            }

            System.out.println("#" + test_case + " " + query);
        }
    }

    private static void edit(List<String> linkedList, StringTokenizer st) {
        String command = st.nextToken();

        if (command.equals("I")) {
            insert(linkedList, st);
        } else if (command.equals("D")) {
            delete(linkedList, st);
        } else {
            change(linkedList, st);
        }
    }

    private static void insert(List<String> linkedList, StringTokenizer st) {
        int idx = Integer.parseInt(st.nextToken());
        String number = st.nextToken();

        linkedList.add(idx, number);
    }

    private static void delete(List<String> linkedList, StringTokenizer st) {
        int idx = Integer.parseInt(st.nextToken());

        linkedList.remove(idx);
    }

    private static void change(List<String> linkedList, StringTokenizer st) {
        int idx = Integer.parseInt(st.nextToken());
        String number = st.nextToken();

        linkedList.set(idx, number);
    }
}