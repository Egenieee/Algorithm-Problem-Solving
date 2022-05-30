package programmers.pair_to_remove;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("abbbabbb"));
    }
    public int solution(String s) {
        String input = s;

        while (true) {
            input = removeOneStep(input);
            if (input.length() == 0) {
                return 1;
            }
            if (input.equals("0")) {
                return 0;
            }
        }
    }

    private String removeOneStep(String s) {
        int idxOfCompare = 0;
        char compare = s.charAt(0);

        for (int i = 1 ; i < s.length() ; i++) {
            if (s.charAt(i) == (compare)) {
                String pattern = String.valueOf(compare).repeat(2);
                s = s.replace(pattern, "");
                return s;
            } else {
                idxOfCompare++;
            }

            compare = s.charAt(idxOfCompare);
        }

        return "0";
    }
}
