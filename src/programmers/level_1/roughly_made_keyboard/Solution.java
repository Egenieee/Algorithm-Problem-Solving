package programmers.level_1.roughly_made_keyboard;

import java.util.Arrays;

// ["ABACD", "BCEFD"]	["ABCD","AABB"]	[9, 4]
//["AA"]	["B"]	[-1]
//["AGZ", "BSSS"]	["ASA","BGZ"]	[4, 6]
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"ABCD", "BCDF", "DND"}, new String[]{"Z", "XX"})));
    }

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int index = 0;

        for (String target : targets) {
            answer[index++] = getCountPressButton(keymap, target);
        }

        return answer;
    }

    private int getCountPressButton(String[] keymap, String target) {
        int count ;
        int allCount = 0;

        String[] targetLetter = target.split("");

        for (String letter : targetLetter) {
            count = getEachLetterCount(letter, keymap);

            if (count == -1) {
                return -1;
            }

            allCount += count;
        }

        return allCount;
    }

    private int getEachLetterCount(String letter, String[] keymap) {
        int minCount = Integer.MAX_VALUE;
        int count;

        for (String key : keymap) {
            count = getMinimumCount(key, letter);

            if (count < minCount) {
                minCount = count;
            }
        }

        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }

        return minCount;
    }

    // ABACD로 A 만들기
    private int getMinimumCount(String key, String targetLetter) {
        for (int i = 0 ; i < key.length() ; i++) {
            if (key.charAt(i) == targetLetter.charAt(0)) {
                return i + 1;
            }
        }

        return Integer.MAX_VALUE;
    }
}
