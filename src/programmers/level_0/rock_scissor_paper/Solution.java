package programmers.level_0.rock_scissor_paper;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("250"));
    }

    public String solution(String rsp) {
        StringBuilder result = new StringBuilder();

        String[] rockScissorPaper = rsp.split("");
        Map<String, String> rspWinTable = new HashMap<>();

        rspWinTable.put("2", "0");
        rspWinTable.put("5", "2");
        rspWinTable.put("0", "5");

        for (String eachRsp : rockScissorPaper) {
            result.append(rspWinTable.get(eachRsp));
        }

        return result.toString();
    }
}
