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

public class Solution {
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
        String[][] infos = getInfos(info);
        String[][] queries = getQueries(query);

        List<Integer> answer = new ArrayList<>();

        for (String[] eachQuery : queries) {
            answer.add(getCountOfMatch(eachQuery, infos));
        }

        return answer;
    }

    private int getCountOfMatch(String[] eachQuery, String[][] infos) {
        int countOfMatch = 0;
        int count;

        for (String[] info : infos) {
            count = 0;
            if (eachQuery[0].equals(info[0]) || eachQuery[0].equals("-")) {
                count++;
            }
            if (eachQuery[1].equals(info[1]) || eachQuery[1].equals("-")) {
                count++;
            }
            if (eachQuery[2].equals(info[2]) || eachQuery[2].equals("-")) {
                count++;
            }
            if (eachQuery[3].equals(info[3]) || eachQuery[3].equals("-")) {
                count++;
            }
            if (Integer.parseInt(info[4]) >= Integer.parseInt(eachQuery[4]) || eachQuery[4].equals("-")) {
                count++;
            }

            if (count == 5) {
                countOfMatch++;
            }
        }

        return countOfMatch;
    }

    private String[][] getInfos(String[] info) {
        String[][] infos = new String[info.length][5];

        for (int i = 0 ; i < info.length ; i++) {
            infos[i] = info[i].split(" ");
        }

        return infos;
    }

    private String[][] getQueries(String[] query) {
        String[][] queries = new String[query.length][5];

        for (int i = 0 ; i < query.length ; i++) {
            int pointer = 0;
            String[] temp = query[i].split(" ");
            for (int j = 0 ; j < temp.length ; j++) {
                if (j == 7 || j % 2 != 1) {
                    queries[i][pointer] = temp[j];
                    pointer++;
                }
            }
        }

        return queries;
    }

}
