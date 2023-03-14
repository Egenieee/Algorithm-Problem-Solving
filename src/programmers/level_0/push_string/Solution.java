package programmers.level_0.push_string;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("hiio", "iohi"));
    }

    public int solution(String A, String B) {
        int numberOfString = A.length();
        int swiftedCount = 0;

        String swiftedString = A;

        if (A.equals(B)) {
            return swiftedCount;
        }

        // 맨 끝거 따로 저장하고 하나씩 오른쪽으로 밀기
        for (int i = 0; i < numberOfString; i++) {
            swiftedString = getNewString(swiftedString);

            swiftedCount++;

            if (swiftedString.equals(B)) {
                return swiftedCount;
            }
        }


        return -1;
    }

    private String getNewString(String a) {
        String[] strings = a.split("");

        String last = strings[a.length() - 1];

        for (int i = strings.length - 2; i >= 0; i--) {
            strings[i + 1] = strings[i];
        }

        strings[0] = last;

        return String.join("", strings);
    }
}
