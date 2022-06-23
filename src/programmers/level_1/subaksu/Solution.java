package programmers.level_1.subaksu;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2));
    }
    public String solution(int n) {
        String answer = "";

        int two;

        if(n % 2 == 0) {
            two = n / 2;
            for(int i = 0 ; i < two ; i++) {
                answer += "수박";
            }

        } else {
            two = n / 2;

            for(int i = 0 ; i < two ; i++) {
                answer += "수박";
            }
            answer += "수";
        }


        return answer;
    }
}
