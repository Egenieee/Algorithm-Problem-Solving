package programmers.level_2.word_relay;

import java.util.*;

// "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" 3
// "hello", "one", "even", "never", "now", "world", "draw" 2
// "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive" 5

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3,
                new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
    }

    public List<Integer> solution(int n, String[] words) {
        List<Integer> answer = Arrays.asList(0, 0);
        Set<String> wordSetForChecking = new HashSet<>();
        List<String> wordList = new ArrayList<>();

        wordSetForChecking.add(words[0]);
        wordList.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String nextWord = words[i];
            char nextLastLetter = nextWord.charAt(0);

            String lastWord = wordList.get(i - 1);
            char lastLetter = lastWord.charAt(lastWord.length() - 1);

            if (nextLastLetter == lastLetter && !wordSetForChecking.contains(nextWord)) {
                wordSetForChecking.add(nextWord);
                wordList.add(nextWord);
            } else {
                return getFirstLoser(n, i);
            }
        }


        return answer;
    }

    private List<Integer> getFirstLoser(int n, int wordIdx) {
        List<Integer> answer = new ArrayList<>();

        answer.add(wordIdx % n + 1);
        answer.add(wordIdx / n + 1);

        return answer;
    }
}
