package backjoon.silver.silver_5.sort_by_age;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 회원을 나이순으로 정렬하되, 나이가 같으면 가입순으로 정렬

public class Main {
    static class Member implements Comparable<Member> {
        private final int age;
        private final int registerOrder;
        private final String name;

        public Member (int registerOrder, int age, String name) {
            this.registerOrder = registerOrder;
            this.age = age;
            this.name = name;
        }
        public int getAge() {
            return age;
        }

        public int getRegisterOrder() {
            return registerOrder;
        }

        public String getInfo() {
            return age + " " + name;
        }

        @Override
        public int compareTo(Member o) {
            if (age == o.getAge()) {
                return registerOrder - o.getRegisterOrder();
            }

            return age - o.getAge();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>();

        for (int registerOrder = 1 ; registerOrder <= N ; registerOrder++) {
            st = new StringTokenizer(br.readLine());
            members.add(new Member(registerOrder, Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(members);

        for (Member member : members) {
            bw.write(member.getInfo() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
