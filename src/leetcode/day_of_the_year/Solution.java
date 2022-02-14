package leetcode.day_of_the_year;

import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.dayOfYear("1997-08-29");
    }
    public int dayOfYear(String date) {
        String[] dateArray = date.split("-");
        int[] dates = Stream.of(dateArray).mapToInt(Integer::parseInt).toArray();

        int day = 0;

        for(int i = 1 ; i < dates[1] ; i++) { //입력한 달 전까지 연산을 반복하는 반복문
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                day += 31;
            } else if(i == 4 || i == 6 || i == 9 || i == 11) {
                day += 30;
            } else if(i == 2) {
                if((dates[0] % 400 == 0) || ((dates[0] % 4 == 0 && dates[0] % 100 != 0))) { //윤년일 경우엔
                    day += 29; //29일까지 있음.
                } else {
                    day += 28; //윤년이 아니면 28일 더해줌.
                }
            }
        }

        if(dates[1] == 1) { //1월일 경우엔
            day = dates[2]; //입력 받은 일 그대로 저장
        } else { //아니면 해당 달의 남은 일까지 저장
            day += dates[2];
        }

        System.out.println("day = " + day);

        return day;
    }
}
