package programmers.pair_to_remove;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("cbbbbdggdc"));
    }
    public int solution(String s) {
        int loopCount = s.length();
        boolean isRemoved;
        List<String> words = getWords(s);

        for (int i = 0 ; i < loopCount ; i++) {
            isRemoved = removeOneStep(words);
            if (!isRemoved || words.size() == 1) {
                return 0;
            }
            if (words.size() == 0) {
                return 1;
            }
        }

        return 0;
    }

    private boolean removeOneStep(List<String> words) {
        int idxOfCompare = 0;
        String compare = words.get(0);

        for (int i = 1 ; i < words.size() ; i++) {
            if (words.get(i).equals(compare)) {
                words.remove(idxOfCompare);
                words.remove(idxOfCompare);
                return true;
            } else {
                idxOfCompare++;
            }

            compare = words.get(idxOfCompare);
        }

        return false;
    }

    private List<String> getWords(String s) {
        String[] word = s.split("");

        return Stream.of(word).collect(Collectors.toList());
    }
}
