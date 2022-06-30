package programmers.level_1.darts_game;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("10S10D2T*"));
    }
    public int solution(String dartResult) {
        int[] scores = new int[3];

        // 입력 점수 문자열 스플릿해서 배열에 저장
        String[] stringScores = getStringScores(dartResult);

        for (int i = 0 ; i < scores.length ; i++) {
            // 원 점수 구하고
            scores[i] = getOriginalScore(stringScores[i]);

            // 아차상이나 스타상이 있다면 점수 다시 계산해서 저장
            if (hasStarOrPound(stringScores[i])) {
                calculateScore(scores, stringScores[i], i);
            }
        }

        // 3 stage 점수 합산하여 리턴
        return Arrays.stream(scores).sum();
    }

    // 인풋 문자열을 각 스테이지마다 스플릿하여 배열에 담은 뒤에 리턴
    private String[] getStringScores(String dartResult) {
        int idx = 0;
        int splitStartIdx = 0;
        int splitEndIdx;

        boolean meetBonus = false;

        String[] stringScores = new String[3];

        for (int i = 0; i < dartResult.length(); i++) {
            // 세번째 스테이지 점수는 스플릿시작 인덱스부터 끝까지 잘라서 배열에 담고 리턴
            if (idx == 2) {
                stringScores[idx] = dartResult.substring(splitStartIdx);
                break;
            }
            // 보너스 점수를 만나면 한 스테이지의 점수를 끊을 조건이 된다. 아차상이나 스타상을 만날 수 있지만, 일단 그건 옵션이니까 보너스 문자열로 판단한다.
            if (dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T') {
                meetBonus = true;
            }
            // 보너스 점수를 만났고, 새로운 숫자가 나타나면 해당 인덱스를 문자열을 서브스트링할 끝 인덱스가 된다. -> 끝 인덱스 전까지 서브스트링으로 만들기 때문
            if (dartResult.charAt(i) - '0' <= 10 && dartResult.charAt(i) - '0' >= 0 && meetBonus) {
                splitEndIdx = i; // 끝 인덱스를 넣어주고
                stringScores[idx++] = dartResult.substring(splitStartIdx, splitEndIdx); // 서브스트링을 저장한 뒤에
                splitStartIdx = i; // 다음 점수의 시작 인덱스를 설정하고
                meetBonus = false; // 보너스 점수를 만났다는 변수는 다시 false 로 세팅한다.
            }
        }

        return stringScores;
    }

    // 한 스테이지의 점수 문자열을 받아서 숫자와 문자열만 추출한 뒤에 점수를 계산한다.
    private int getOriginalScore(String stringScore) {
        int score = Integer.parseInt(stringScore.replaceAll("[^0-9]", ""));
        String bonus = stringScore.replaceAll("[^a-zA-Z]", "");

        if (bonus.equals("S")) {
            return (int) Math.pow(score, 1);
        }else if (bonus.equals("D")) {
            return (int) Math.pow(score, 2);
        }

        return (int) Math.pow(score, 3);
    }

    // 점수 문자열을 받은 뒤에 맨 마지막 문자열이 아차상이나 스타상일 경우 true를 반환한다.
    private boolean hasStarOrPound(String stringScore) {
        char lastLetter = stringScore.charAt(stringScore.length() - 1);
        return  lastLetter == '*' || lastLetter == '#';
    }

    // 아차상이나 스타상이 있다면 이 전 스테이지 결과를 새로 업데이트 해준다.
    private void calculateScore(int[] scores, String stringScore, int i) {
        char option = stringScore.charAt(stringScore.length() - 1);

        // 아차상일 경우 자기 자신 점수만 업데이트한다.
        if (option == '#') {
            scores[i] *= -1;
        } else { // 스타상일 경우
            if (i != 0) { // 두번째, 세번째 스테이지면 이전 스테이지 점수도 2배로 계산한다.
                scores[i - 1] *= 2;
            }
            scores[i] *= 2;
        }
    }
}
