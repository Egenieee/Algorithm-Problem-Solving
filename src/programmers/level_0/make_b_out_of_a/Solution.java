package programmers.level_0.make_b_out_of_a;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("apple", "aelpp"));
    }

    public int solution(String before, String after) {
        int[] beforeAlphabet = getAlphabetTable(before);
        int[] afterAlphabet = getAlphabetTable(after);

        if (isSameAlphabetCombination(beforeAlphabet, afterAlphabet)) {
            return 1;
        }

        return 0;
    }

    private int[] getAlphabetTable(String word) {
        int[] alphabetTable = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int alphabet = word.charAt(i) - 97;
            alphabetTable[alphabet] += 1;
        }

        return alphabetTable;
    }

    private boolean isSameAlphabetCombination(int[] beforeAlphabet, int[] afterAlphabet) {
        for (int i = 0; i < beforeAlphabet.length; i++) {
            if (beforeAlphabet[i] != afterAlphabet[i]) {
                return false;
            }
        }

        return true;
    }
}
