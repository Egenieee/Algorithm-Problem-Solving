package programmers.level_0.login_succeed;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"meosseugi", "1234"}, new String[][]{{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}}));
    }

    public String solution(String[] id_pw, String[][] db) {
        for (String[] information : db) {
            if (isSucceed(information, id_pw)) {
                return "login";
            }

            if (isWrongPw(information, id_pw)) {
                return "wrong pw";
            }
        }

        return "fail";
    }

    private boolean isSucceed(String[] information, String[] id_pw) {
        return information[0].equals(id_pw[0]) && information[1].equals(id_pw[1]);
    }

    private boolean isWrongPw(String[] information, String[] id_pw) {
        return information[0].equals(id_pw[0]) && !information[1].equals(id_pw[1]);
    }
}
