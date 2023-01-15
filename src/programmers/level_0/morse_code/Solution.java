package programmers.level_0.morse_code;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(".... . .-.. .-.. ---"));
    }

    public String solution(String letter) {
        Map<String, String> morseCodeTable = getMorseCodeTable();

        String[] letters = letter.split(" ");

        StringBuilder result = new StringBuilder();

        for (String morseCode : letters) {
            result.append(morseCodeTable.get(morseCode));
        }

        return result.toString();
    }

    private Map<String, String> getMorseCodeTable() {
        Map<String, String> morseCodeTable = new HashMap<>();

        morseCodeTable.put(".-", "a");
        morseCodeTable.put("-...", "b");
        morseCodeTable.put("-.-.", "c");
        morseCodeTable.put("-..", "d");
        morseCodeTable.put(".", "e");
        morseCodeTable.put("..-.", "f");
        morseCodeTable.put("--.", "g");
        morseCodeTable.put("....", "h");
        morseCodeTable.put("..", "i");
        morseCodeTable.put(".---", "j");
        morseCodeTable.put("-.-", "k");
        morseCodeTable.put(".-..", "l");
        morseCodeTable.put("--", "m");
        morseCodeTable.put("-.", "n");
        morseCodeTable.put("---", "o");
        morseCodeTable.put(".--.", "p");
        morseCodeTable.put("--.-", "q");
        morseCodeTable.put(".-.", "r");
        morseCodeTable.put("...", "s");
        morseCodeTable.put("-", "t");
        morseCodeTable.put("..-", "u");
        morseCodeTable.put("...-", "v");
        morseCodeTable.put(".--", "w");
        morseCodeTable.put("-..-", "x");
        morseCodeTable.put("-.--", "y");
        morseCodeTable.put("--..", "z");

        return morseCodeTable;
    }
}
