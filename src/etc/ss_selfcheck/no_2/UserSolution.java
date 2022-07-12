package etc.ss_selfcheck.no_2;

import java.sql.Struct;
import java.util.*;

public class UserSolution {
    LinkedList<Student> DB;

    static class Student {
        int mId;
        int mGrade;
        char[] mGender;
        int mScore;

        public Student(int mId, int mGrade, char[] mGender, int mScore) {
            this.mId = mId;
            this.mGrade = mGrade;
            this.mGender = mGender;
            this.mScore = mScore;
        }
    }

    public void init() {
        DB = new LinkedList<>();
    }

    public int add(int mId, int mGrade, char[] mGender, int mScore) {
        // 학생 ID가 mId이고, 학년이 mGrade, 성별이 mGender인 학생의 점수 mScore를 추가한다.
        DB.add(new Student(mId, mGrade, mGender, mScore));

        List<Student> list = new ArrayList<>();

        // mGrade mGender 인 학생 중에서 점수가 가장 높은 학생의 ID 반환
        // 점수가 가장 높은 학생이 여러 명이라면, 그 중에서 ID가 가장 큰 값을 반환한다.

        String addedMGender = String.valueOf(mGender);

        for (Student student : DB) {
            String studentMGender = String.valueOf(student.mGender);
            if (student.mGrade == mGrade && studentMGender.equals(addedMGender)) {
                list.add(student);
            }
        }

        Comparator<Student> idSort = new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                if (student.mScore == t1.mScore) {
                    return student.mId - t1.mId;
                }
                return student.mScore - t1.mScore;
            }
        };

        list.sort(idSort);

        return list.get(0).mId;
    }

    public int remove(int mId) {
        // 학생 ID가 mId인 학생의 기록을 삭제한다.
        //시스템에 mId 학생의 점수가 기록되어 있지 않다면, 0을 반환한다.
        Student studentToRemove = null;

        for (Student student : DB) {
            if (student.mId == mId) {
                studentToRemove = student;
                break;
            }
        }

        if(studentToRemove == null) {
            return 0;
        }

        DB.remove(studentToRemove);

        //삭제 후에 mId 학생의 학년과 성별이 동일한 학생 중에서 점수가 가장 낮은 학생의 ID를 반환한다.
        //점수가 가장 낮은 학생이 여러 명이라면, 그 중에서 ID가 가장 작은 값을 반환한다.
        //삭제 후에, 학년과 성별이 동일한 학생이 없다면, 0을 반환한다.

        List<Student> list = new ArrayList<>();
        String removedMGender = String.valueOf(studentToRemove.mGender);

        for (Student student : DB) {
            String studentMGender = String.valueOf(student.mGender);
            if (student.mGrade == studentToRemove.mGrade && studentMGender.equals(removedMGender)) {
                list.add(student);
            }
        }

        if (list.isEmpty()) {
            return 0;
        }

        Comparator<Student> idSort = new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                if (student.mScore == t1.mScore) {
                    return t1.mId - student.mId;
                }
                return t1.mScore - student.mScore;
            }
        };

        list.sort(idSort);

        return list.get(0).mId;
    }

    public int query(int mGradeCnt, int[] mGrade, int mGenderCnt, char[][] mGender, int mScore) {
        // mGrade 학년 집합과 mGender 성별 집합에 속하면서, 점수가 mScore 이상인 학생 중에서 점수가 가장 낮은 학생의 ID를 반환한다.
        //점수가 가장 낮은 학생이 여러 명이라면, 그 중에서 ID가 가장 작은 값을 반환한다.
        //mGradeCnt 개의 학년이 mGrade 배열로 주어진다. 예를 들어, 1학년과 3학년이라면 {1, 3}로 주어진다.
        //mGenderCnt 개의 성별이 mGender 배열로 주어진다. 예를 들어, 남성이라면 {“male”}로 주어지고, 남성과 여성이라면 {“male”, “female”}로 주어진다.
        //점수가 mScore 이상인 학생이 없다면, 0을 반환한다.

        Student studentToSearch = null;
        List<Student> list = new ArrayList<>();

        for (Student student : DB) {
            String studentMGender = String.valueOf(student.mGender);
            loop :
            for (int i = 0 ; i < mGradeCnt ; i++) {
                for (int j = 0 ; j < mGenderCnt ; j++) {
                    String queryMGender = String.valueOf(mGender[j]);
                    if (student.mGrade == mGrade[i] && studentMGender.equals(queryMGender) && student.mScore >= mScore) {
                        list.add(student);
                        break loop;
                    }
                }
            }
        }

        if (list.isEmpty()) {
            return 0;
        }

        Comparator<Student> idSort = new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                if (student.mScore == t1.mScore) {
                    return t1.mId - student.mId;
                }
                return t1.mScore - student.mScore;
            }
        };

        list.sort(idSort);

        return list.get(0).mId;
    }
}