package programmers.level_1.getting_report_results;

import java.util.*;

/*
input ["muzi", "frodo", "apeach", "neo"]
      ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
       2
return [2,1,1,0] 순서대로 무지, 프로도, 어피치, 네오가 받을 신고 결과 메일의 개수 리턴

report split해서 누가 누구를 몇번 신고했는지 검출 근데 같은 유저가 한 유저를 여러번 신고할 경우엔 1회 신고로 처리
Map을 써볼까
*/

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2)));
    }
    public int[] solution(String[] id_list, String[] report, int k) {

        // id list 개수만큼 초기화
        int[] answer = new int[id_list.length];

        // 신고당한 유저와 몇 번 신고 당했는지 기록할 map
        Map<String, Integer> usersAndNrReport = new HashMap<>();
        // 신고 한 유저와 몇 개의 정지 메일을 받을 지 기록할 map
        Map<String, Integer> usersAndNrMails = new HashMap<>();
        // 신고당한 유저 중 정지 당할 유저인지 아닌지 판단하는 map
        Map<String, Boolean> isSuspened = new HashMap<>();

        // 두 가지 map 초기화
        for(String user_name : id_list) {
            isSuspened.put(user_name, false);
            usersAndNrMails.put(user_name, 0);
        }

        // 한 유저가 특정 유저를 여러번 신고했을 경우를 제외. 셋에 담긴 것 모두 처리하면 됨.
        Set<String> reports = new HashSet<>(Arrays.asList(report));

        // 각각의 report 받아서 split한 뒤에 신고 현황 검출할거임
        for(String each_report : reports) {
            String[] reporting = each_report.split(" ");
            // 각각의 유저가 신고를 몇번 받았는지 맵에 기록
            usersAndNrReport.put(reporting[1], usersAndNrReport.getOrDefault(reporting[1], 0) +1);
        }

        // 그 다음 2번 이상 신고 받은 애만 true로 바꿔줌 --> 정지 먹임
        for(String reported_name : usersAndNrReport.keySet()) {
            int numOfReports = usersAndNrReport.get(reported_name);
            if (numOfReports >= k) {
                isSuspened.put(reported_name, true);
            }
        }

        // 신고한 사람이 정지가 됐으면 메일을 날려줘야 됨. 메일 받을 수를 체크하자.
        for(String each_report : reports) {
            String[] reporting = each_report.split(" ");
            // 만약 유저가 신고 한 사람이 정지 당할 사람이라면?
            if (isSuspened.get(reporting[1])) {
                // 유저가 받을 정지 메일 수를 하나 증가 시킨다.
                usersAndNrMails.put(reporting[0], usersAndNrMails.getOrDefault(reporting[0], 0) + 1);
            }
        }

        // 입력 id list 순서 대로 받을 메일의 수 int array에 담자
        int name_idx = 0;
        for (String name : id_list) {
            // get으로 받을 메일의 수 받아옴
            int get_nr_mails = usersAndNrMails.get(name);
            // 배열에 메일의 수 차례로 넣어줌
            answer[name_idx] = get_nr_mails;
            name_idx++;
        }

        return answer;
    }
}
