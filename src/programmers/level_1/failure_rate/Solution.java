package programmers.failure_rate;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
       List<Integer> result = solution.solution(4, new int[]{1,2,3});
       for(int num : result) {
           System.out.println(num);
       }
    }
    public List<Integer> solution(int N, int[] stages) {
        int numOfUser = stages.length;
        int numOfFail = 0;

        Map<Integer, Float> failure_rate = new HashMap<>();

        for (int i = 1 ; i < N + 1 ; i++) {
            for(int j = 0 ; j < stages.length ; j++) {
                if( i == stages[j] ) {
                    numOfFail++;
                }
            }
            if(numOfFail == 0) {
                failure_rate.put(i, (float)0.0);
            } else {
                failure_rate.put(i, ((float)numOfFail / numOfUser));
            }
            numOfUser -= numOfFail;
            numOfFail = 0;
        }

        // hashmap에서 value 기준으로 내림차순 정렬
        List<Integer> sortedList = new ArrayList<>(failure_rate.keySet());

        Collections.sort(sortedList, (o1, o2) -> (failure_rate.get(o2).compareTo(failure_rate.get(o1))));

        // 정렬한 순서대로 값 새로운 list에 담기
        List<Integer> answer = new ArrayList<>();

        answer.addAll(sortedList);

        return answer;
    }
}
