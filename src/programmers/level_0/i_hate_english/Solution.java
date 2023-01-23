package programmers.level_0.i_hate_english;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("onetwothreetwoone"));
    }

    public long solution(String numbers) {
        Map<String, String> numberTable = getTable();

        for (String number : numberTable.keySet()) {
            numbers = numbers.replace(number, numberTable.get(number));
        }

        return Long.parseLong(numbers);
    }

    private Map<String, String> getTable() {
        Map<String, String> numberTable = new HashMap<>();

        numberTable.put("one", "1");
        numberTable.put("two", "2");
        numberTable.put("three", "3");
        numberTable.put("four", "4");
        numberTable.put("five", "5");
        numberTable.put("six", "6");
        numberTable.put("seven", "7");
        numberTable.put("eight", "8");
        numberTable.put("nine", "9");
        numberTable.put("zero", "0");

        return numberTable;
    }
}
