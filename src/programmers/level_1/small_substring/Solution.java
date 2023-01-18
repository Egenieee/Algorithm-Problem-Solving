package programmers.level_1.small_substring;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1", "10"));
    }

    public int solution(String t, String p) {
        int count = 0;
        int subStringLength = p.length();

        int startIndex = 0;

        while (startIndex != t.length() - subStringLength + 1) {
            String subString = t.substring(startIndex, startIndex + subStringLength);

            if (isBigThanPString(subString, p)) {
                count++;
            }

            startIndex++;
        }

        return count;
    }

    private boolean isBigThanPString(String subString, String p) {
        return Long.parseLong(subString) <= Long.parseLong(p);
    }
}
