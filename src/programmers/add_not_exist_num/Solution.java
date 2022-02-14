package programmers.add_not_exist_num;

import java.util.HashMap;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[] {1,2,3,4,6,7,8,0});
    }
    public int solution(int[] numbers) {
        int answer = 0;

        HashMap<Integer, Integer> notExistNums = new HashMap<>();

        for(int i = 0 ; i < 10 ; i++) {
            notExistNums.put(i,i);
        }

        for(int num : numbers) {
            notExistNums.remove(num);
        }

        Set<Integer> keySet = notExistNums.keySet();

        for(int key : keySet) {
            answer += key;
        }

        return answer;
    }
}
