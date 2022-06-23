package programmers.level_1.p_and_y_count;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("Piiyyy"));
    }
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                pCount++;
            } else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}
