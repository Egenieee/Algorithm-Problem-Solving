package programmers.level_0.alien_dictionary;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"z", "d", "x"}, new String[]{"def", "dww", "dzx", "loveaw"}));
    }

    public int solution(String[] spell, String[] dic) {
        for (String word : dic) {
            if (isValidWord(word, spell)) {
                return 1;
            }
        }

        return 2;
    }

    private boolean isValidWord(String word, String[] spell) {
        for (String alphabet : spell) {
            if (!word.contains(alphabet)) { // spell의 원소 모두가 포함되어야 하니까 하나라도 포함되지 않으면 false 반환
                return false;
            }
        }

        return true;
    }
}
