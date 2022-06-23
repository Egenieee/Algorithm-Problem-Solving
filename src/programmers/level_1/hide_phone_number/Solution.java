package programmers.hide_phone_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("01023202304"));
    }
    public String solution(String phone_number) {
        String backNumber = phone_number.substring(phone_number.length() - 4);
        phone_number = phone_number.substring(0, phone_number.length() - 4);

        phone_number = phone_number.replaceAll("[0-9]", "*");

        phone_number = phone_number + backNumber;

        return phone_number;
    }
}
