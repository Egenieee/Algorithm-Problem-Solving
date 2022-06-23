package programmers.mock_exam;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1,3,2,4,2}));
    }
    public List<Integer> solution(int[] answers) {

        // 수포자 1, 2, 3의 답안지 만들기
        List<Integer> one = getAnswerOne();
        List<Integer> two = getAnswerTwo();
        List<Integer> three = getAnswerThree();

        // 각 몇 개의 문제를 맞췄는지 구하기
        int countOne = getCorrectAnswerCount(one, answers);
        int countTwo = getCorrectAnswerCount(two, answers);
        int countThree = getCorrectAnswerCount(three, answers);

        Map<Integer, Integer> result = new HashMap<>();
        result.put(1, countOne);
        result.put(2, countTwo);
        result.put(3, countThree);

        // 누가 제일 많이 맞췄는 지 구하기

        List<Integer> answer = getResult(result);

        return answer;
    }

    private List<Integer> getAnswerOne() {
        // 1 2 3 4 5 1 2 3 4 5
        List<Integer> answer = new ArrayList<>();
        for (int i = 0 ; i < 2000 ; i++) {
            answer.add(1);
            answer.add(2);
            answer.add(3);
            answer.add(4);
            answer.add(5);
        }
        return answer;
     }
    private List<Integer> getAnswerTwo() {
        // 2 1 2 3 2 4 2 5
        List<Integer> answer = new ArrayList<>();
        for (int i = 0 ; i < 1250 ; i++) {
            answer.add(2);
            answer.add(1);
            answer.add(2);
            answer.add(3);
            answer.add(2);
            answer.add(4);
            answer.add(2);
            answer.add(5);
        }
        return answer;
    }
    private List<Integer> getAnswerThree() {
        // 3 3 1 1 2 2 4 4 5 5
        List<Integer> answer = new ArrayList<>();
        for (int i = 0 ; i < 1000 ; i++) {
            answer.add(3);
            answer.add(3);
            answer.add(1);
            answer.add(1);
            answer.add(2);
            answer.add(2);
            answer.add(4);
            answer.add(4);
            answer.add(5);
            answer.add(5);
        }
        return answer;
    }

    private int getCorrectAnswerCount(List<Integer> student, int[] answers) {
        int count = 0;
        for (int i = 0 ; i < answers.length ; i++) {
            if (answers[i] == student.get(i)) {
                count++;
            }
        }
        return count;
    }


    private List<Integer> getResult(Map<Integer, Integer> result) {
        List<Integer> answer = new ArrayList<>();
        int maxCount = 0;
        for (int student : result.keySet()) {
            if (maxCount < result.get(student)) {
                maxCount =result.get(student);
            }
        }

        for (int student : result.keySet()) {
            if (maxCount == result.get(student)) {
                answer.add(student);
            }
        }

        return answer;
    }
}
