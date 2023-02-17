package programmers.level_1.password_for_two_of_us;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println((solution.solution("soy", "wbqd", 5)));
    }

    public String solution(String s, String skip, int index) {
        StringBuilder stringBuilder = new StringBuilder();

        List<String> alphabetTable = getAlphabetTable(skip);

        // 자기 자신보다 index 앞선 알파벳으로 교체한다.
        for (int i = 0; i < s.length(); i++) {
            int targetAlphabet = getIndex(String.valueOf(s.charAt(i)), alphabetTable);
            int encryption = (targetAlphabet + index) % alphabetTable.size();

            stringBuilder.append(alphabetTable.get(encryption));
        }

        return stringBuilder.toString();
    }

    private int getIndex(String alphabet, List<String> alphabetTable) {
        for (int i = 0; i < alphabetTable.size(); i++) {
            if (alphabetTable.get(i).equals(alphabet)) {
                return i;
            }
        }

        return -1;
    }

    private List<String> getAlphabetTable(String skip) {
        List<String> alphabets = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (!skip.contains(String.valueOf((char) (97 + i)))) {
                alphabets.add(String.valueOf((char) (97 + i)));
            }
        }

        return alphabets;
    }
}
