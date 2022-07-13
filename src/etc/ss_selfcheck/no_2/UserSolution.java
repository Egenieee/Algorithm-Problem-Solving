package etc.ss_selfcheck.no_2;

import java.util.*;

public class UserSolution {
    List<Student> first_male_DB;
    List<Student> first_female_DB;
    List<Student> second_male_DB;
    List<Student> second_female_DB;
    List<Student> third_male_DB;
    List<Student> third_female_DB;
    Map<Integer, Integer> DBSelector;

    static class Student implements Comparable<Student>{
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

        @Override
        public int compareTo(Student student) {
            if (mScore == student.mScore) {
                return mId - student.mId;
            }

            return mScore - student.mScore;
        }
    }

    public void init() {
        first_male_DB = new LinkedList<>();
        first_female_DB = new LinkedList<>();
        second_male_DB = new LinkedList<>();
        second_female_DB = new LinkedList<>();
        third_male_DB = new LinkedList<>();
        third_female_DB = new LinkedList<>();
        DBSelector = new HashMap<>();
    }

    public int add(int mId, int mGrade, char[] mGender, int mScore) {

        // 해당 학년, 성별을 저장하고 있는 DB를 불러온다.
        List<Student> DB;

        String gender = getGenderString(mGender);

        if (gender.equals("male") && mGrade == 1) {
            DBSelector.put(mId, 1);
            DB = first_male_DB;
        } else if (gender.equals("female") && mGrade == 1) {
            DBSelector.put(mId, 2);
            DB = first_female_DB;
        } else if (gender.equals("male") && mGrade == 2) {
            DBSelector.put(mId, 3);
            DB = second_male_DB;
        } else if (gender.equals("female") && mGrade == 2) {
            DBSelector.put(mId, 4);
            DB = second_female_DB;
        } else if (gender.equals("male") && mGrade == 3) {
            DBSelector.put(mId, 5);
            DB = third_male_DB;
        } else {
            DBSelector.put(mId, 6);
            DB = third_female_DB;
        }


        // 학생 ID가 mId이고, 학년이 mGrade, 성별이 mGender인 학생의 점수 mScore를 추가한다.

        // 비어 있으면 그냥 넣는다.
        if (DB.isEmpty()) {
            DB.add(new Student(mId, mGrade, mGender, mScore));
            return mId;
        }

        // 비어 있지 않다면, 링크드리스트를 순회하면서 올바른 자리에 넣어야 한다.
        // 링크드리스트를 순회하면서 자기 점수보다 큰 점수나오면 그 앞에 넣는다.
        int index = 0;

        for (int i = 0 ; i < DB.size() ; i++) {
            // 자기 점수보다 큰 점수 앞에 넣자.
            if (DB.get(i).mScore > mScore) {
                index = i;
                break;
            } else if (DB.get(i).mScore == mScore) { // 만약 점수가 같다면? Id값을 비교해보고 넣는다.
                if (DB.get(i).mId > mId) {
                    index = i;
                } else {
                    index = i + 1;
                }
                break;
            } else {
                index = i + 1;
            }
        }

        DB.add(index, new Student(mId, mGrade, mGender, mScore));

        return DB.get(DB.size() - 1).mId;
    }

    private String getGenderString(char[] mGender) {
        StringBuilder sb = new StringBuilder();

        for (char c : mGender) {
            if (c != 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public int remove(int mId) {

        // 해당 id를 저장하고 있는 DB를 불러온다.
        List<Student> DB;

        // 삭제할 학생의 아이디가 없다면 0 리턴하고 종료한다.
        if (!DBSelector.containsKey(mId)) {
            return 0;
        }

        if (DBSelector.get(mId) == 1) {
            DB = first_male_DB;
        } else if (DBSelector.get(mId) == 2) {
            DB = first_female_DB;
        } else if (DBSelector.get(mId) == 3) {
            DB = second_male_DB;
        } else if (DBSelector.get(mId) == 4) {
            DB = second_female_DB;
        } else if (DBSelector.get(mId) == 5) {
            DB = third_male_DB;
        } else {
            DB = third_female_DB;
        }

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

        if (DB.isEmpty()) {
            return 0;
        }

        return DB.get(0).mId;
    }

    public int query(int mGradeCnt, int[] mGrade, int mGenderCnt, char[][] mGender, int mScore) {
        // mGrade 학년 집합과 mGender 성별 집합에 속하면서, 점수가 mScore 이상인 학생 중에서 점수가 가장 낮은 학생의 ID를 반환한다.
        //점수가 가장 낮은 학생이 여러 명이라면, 그 중에서 ID가 가장 작은 값을 반환한다.
        //mGradeCnt 개의 학년이 mGrade 배열로 주어진다. 예를 들어, 1학년과 3학년이라면 {1, 3}로 주어진다.
        //mGenderCnt 개의 성별이 mGender 배열로 주어진다. 예를 들어, 남성이라면 {“male”}로 주어지고, 남성과 여성이라면 {“male”, “female”}로 주어진다.
        //점수가 mScore 이상인 학생이 없다면, 0을 반환한다.

        List<Student> DB;
        List<Student> save = new ArrayList<>();

        for (int i = 0 ; i < mGradeCnt ; i++) {
            for (int j = 0 ; j < mGenderCnt ; j++) {
                String gender = getGenderString(mGender[j]);

                if (gender.equals("male") && mGrade[i] == 1) {
                    DB = first_male_DB;
                } else if (gender.equals("female") && mGrade[i] == 1) {
                    DB = first_female_DB;
                } else if (gender.equals("male") && mGrade[i] == 2) {
                    DB = second_male_DB;
                } else if (gender.equals("female") && mGrade[i] == 2) {
                    DB = second_female_DB;
                } else if (gender.equals("male") && mGrade[i] == 3) {
                    DB = third_male_DB;
                } else {
                    DB = third_female_DB;
                }

//                for (Student student : DB) {
//                    if (student.mScore >= mScore) {
//                        save.add(student);
//                        break;
//                    }
//                }

                Student student = binarySearch(DB, mScore);

                if (student != null) {
                    save.add(student);
                }

            }
        }

        if (save.isEmpty()) {
            return 0;
        }

        Collections.sort(save);

        return save.get(0).mId;
    }

    private Student binarySearch(List<Student> DB, int mScore) {

        if (DB.size() == 0) {
            return null;
        } else if (DB.size() == 1) {
            if(DB.get(0).mScore >= mScore) {
                return DB.get(0);
            }
            return null;
        }

        int mid;
        int low = 0;
        int high = DB.size() - 1;

        while(low <= high) {
            mid = (low + high) / 2;

            if (mScore <= DB.get(mid).mScore) {
                for (int i = low ; i <= mid ; i++) {
                    if (DB.get(i).mScore >= mScore) {
                        return DB.get(i);
                    }
                }
            } else {
                low = mid + 1;
            }
        }

        return null;
    }
}