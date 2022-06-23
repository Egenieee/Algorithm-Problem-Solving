package programmers.level_2.openChat;

// ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
// ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

// 유저 정보는 맵에 저장하자, key는 유저 아이디, value는 유저 닉네임.
// change 할 때마다 맵 정보 업데이트
// enter, leave는 따로 저장해서 나중에 출력문 만들때 사용하자.

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.solution(new String[]
                {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        for(String commend : result) {
            System.out.println(commend);
        }
    }
    public List<String> solution(String[] record) {
        // user의 최종 닉네임 정보를 받아온다.
        Map<String, String> userInfo = getUserInfo(record);

        // 최종 출력문을 받아온다.
        List<String> result = getResult(record, userInfo);

        return result;
    }

    // enter, change면 유저 아이디-닉네임 맵에 저장하는 로직
    private Map<String, String> getUserInfo(String[] record) {
        Map<String, String> userInfo = new HashMap<>();

        for(String oneCommend : record) {
            String[] splitCommend = oneCommend.split(" ");
            if(splitCommend[0].equals("Enter") || splitCommend[0].equals("Change")) {
                userInfo.put(splitCommend[1], splitCommend[2]);
            }
        }

        return userInfo;
    }

    private List<String> getResult(String[] record, Map<String, String> userInfo) {
        List<String> result = new ArrayList<>();

        // enter 는 "님이 들어왔습니다." leave는 "님이 나갔습니다." 붙여서 출력할 수 있도록 한다.
        for(String oneCommend : record) {
            // 기록문을 split
            StringBuilder stringBuilder = new StringBuilder();
            String[] splitCommend = oneCommend.split(" ");

            if (splitCommend[0].equals("Enter")) {
                stringBuilder.append(userInfo.get(splitCommend[1]));
                stringBuilder.append("님이 들어왔습니다.");

                result.add(stringBuilder.toString());
            } else if(splitCommend[0].equals("Leave")) {
                stringBuilder.append(userInfo.get(splitCommend[1]));
                stringBuilder.append("님이 나갔습니다.");

                result.add(stringBuilder.toString());
            }
        }
        return result;
    }
}
