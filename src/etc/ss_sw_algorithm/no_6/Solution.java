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

            }
        }
    }
}


