package programmers.rank_search;

// info
// "java backend junior pizza 150",
// "python frontend senior chicken 210",
// "python frontend senior chicken 150",
// "cpp backend senior pizza 260",
// "java backend junior chicken 80",
// "python backend senior chicken 50"

// query
// "java and backend and junior and pizza 100",
// "python and frontend and senior and chicken 200",
// "cpp and - and senior and pizza 250",
// "- and backend and senior and - 150",
// "- and - and - and chicken 100",
// "- and - and - and - 150"

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    class Applicant {
        private String language;
        private String job;
        private String career;
        private String soulFood;

        private int score;

        public Applicant(String language, String job, String career, String soulFood, int score) {
            this.language = language;
            this.job = job;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }

        public String getLanguage() {
            return language;
        }

        public String getJob() {
            return job;
        }

        public String getCareer() {
            return career;
        }

        public String getSoulFood() {
            return soulFood;
        }

        public int getScore() {
            return score;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> result = solution.solution(new String[]{"java backend junior pizza 150",
                "python frontend senior chicken 210","python frontend senior chicken 150",
                "cpp backend senior pizza 260","java backend junior chicken 80",
                "python backend senior chicken 50"}, new String[]{"java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150","- and - and - and chicken 100",
                "- and - and - and - 150"});
        System.out.println(result);
    }
    public List<Integer> solution(String[] info, String[] query) {
        // 지원자 객체 생성
        List<Applicant> applicants = new ArrayList<>();
        createApplicants(applicants, info);

        // 조건 검색
        List<Integer> answer = search(applicants, query);

        return answer;
    }
    private void createApplicants(List<Applicant> applicants, String[] info) {
        for (String oneInfo : info) {
            String[] oneInfos = oneInfo.split(" ");

            applicants.add(new Applicant(oneInfos[0], oneInfos[1],
                    oneInfos[2], oneInfos[3], Integer.parseInt(oneInfos[4])));
        }
    }
    private List<Integer> search(List<Applicant> applicants, String[] query) {
        List<Integer> answer = new ArrayList<>();

        // 쿼리 하나씩 보면서 조건 검색
        // conditions[0] = language, condition[2] = job, conditions[4] = career
        // conditions[6] = soulFood, conditions[7] = score

        for (String condition : query) {
            String[] conditions = condition.split(" ");

            List<Applicant> searched = applicants.stream()
                    .filter(applicant -> {
                        if(!conditions[0].equals("-")) {
                            return applicant.getLanguage().equals(conditions[0]);
                        }
                        return true;
                    })
                    .filter(applicant -> {
                        if(!conditions[2].equals("-")) {
                            return applicant.getJob().equals(conditions[2]);
                        }
                        return true;
                    })
                    .filter(applicant -> {
                        if(!conditions[4].equals("-")) {
                            return applicant.getCareer().equals(conditions[4]);
                        }
                        return true;
                    })
                    .filter(applicant -> {
                        if(!conditions[6].equals("-")) {
                            return applicant.getSoulFood().equals(conditions[6]);
                        }
                        return true;
                    })
                    .filter(applicant -> applicant.getScore() >= Integer.parseInt(conditions[7]))
                    .collect(Collectors.toList());

            answer.add(searched.size());
        }
        return answer;
    }
}
