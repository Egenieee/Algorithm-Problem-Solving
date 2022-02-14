package programmers.year_2016;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(9, 25);
    }
    public String solution(int a, int b) {
        String answer = "";

        String[] day = {"FRI", "SAT","SUN", "MON", "TUE" ,"WED" ,"THU"};
        int[] eachDayCount = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int allDates = 0;

        for(int i = 0; i < a - 1 ; i++) {
            allDates += eachDayCount[i];
        }

        allDates += (b - 1);

        answer = day[allDates % 7];

        return answer;
    }
}
