package programmers.level_1.recommend_new_id;

// new_id에 나타낼 수 있는 문자 -_.~!@#$%^&*()=+[{]}:?,<>/
// 허용되지 않는 문자 ~!@#$%^&*()=+[{]}:?,<>/

import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("=.@#!!-_---_@#..="));
    }

    public String solution(String new_id) {
        String answer = getStageOneId(new_id);
        answer = getStageTwoId(answer);
        answer = getStageThreeId(answer);
        answer = getStageFourId(answer);
        answer = getStageFiveId(answer);
        answer = getStageSixId(answer);
        answer = getStageSevenId(answer);

        return answer;
    }

    // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    private String getStageOneId(String new_id) {
        return new_id.toLowerCase(Locale.ROOT);
    }

    //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    private String getStageTwoId(String new_id) {
        String id = new_id;

        id = id.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]", "");

        return id;
    }

    //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    private String getStageThreeId(String new_id) {
        String id = new_id;

        id = id.replaceAll("[.]{2,}", ".");

        return id;
    }

    //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    private String getStageFourId(String new_id) {
        String id = new_id;

        if(id.length() == 1 && id.charAt(0) == '.') {
            id = "";
            return id;
        }
        if (id.charAt(0) == '.') {
            id = id.substring(1);
        }
        if (id.charAt(id.length() - 1) == '.') {
            id = id.substring(0, id.length() - 1);
        }

        return id;
    }

    //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    private String getStageFiveId(String new_id) {
        String id = new_id;

        if (new_id.isEmpty()) {
            id = "a";
        }

        return id;
    }

    //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    private String getStageSixId(String new_id) {
        String id = new_id;


        if (id.length() >= 15) {
            id = id.substring(0, 15);
            if (id.charAt(14) == '.') {
                id = id.substring(0, 14);
            }
        }

        return id;
    }

    //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    private String getStageSevenId(String new_id) {
        StringBuilder id = new StringBuilder(new_id);
        String additional_id;

        if (id.length() <= 2) {
            additional_id = id.substring(id.length() - 1);
            id.append(String.valueOf(additional_id).repeat(Math.max(0, 3 - id.length())));
        }

        return id.toString();
    }
}
