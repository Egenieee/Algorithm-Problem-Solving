package programmers.level_0.national_competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    static class Student implements Comparable<Student> {
        int rank;
        int number;

        public Student(int rank, int number) {
            this.rank = rank;
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public int compareTo(Student o) {
            if (this.rank > o.rank) {
                return 1;
            } else if (this.rank == o.rank) {
                return 0;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3, 7, 2, 5, 4, 6, 1}, new boolean[]{false, true, true, true, true, false, false}));
    }

    public int solution(int[] rank, boolean[] attendance) {
        List<Student> canAttendance = new ArrayList<>();

        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                canAttendance.add(new Student(rank[i], i));
            }
        }

        Collections.sort(canAttendance);

        return 10000 * canAttendance.get(0).getNumber() + 100 * canAttendance.get(1).getNumber() + canAttendance.get(2).getNumber();
    }
}
