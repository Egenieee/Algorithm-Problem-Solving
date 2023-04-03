package programmers.level_0.characters_coordinate;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"down", "down", "down", "down", "down", "down", "left", "left", "left", "left", "left"}, new int[]{7, 9})));
    }

    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[]{0, 0};

        for (String direction : keyinput) {
            if (isValidCoordinate(answer, direction, board)) {
                move(answer, direction);
            }
        }

        return answer;
    }

    private boolean isValidCoordinate(int[] answer, String direction, int[] board) {
        int coordinate;

        if (direction.equals("up")) {
            coordinate = answer[1] + 1;
            return isValidYCoordinate(coordinate, board);
        }

        if (direction.equals("down")) {
            coordinate = answer[1] - 1;
            return isValidYCoordinate(coordinate, board);
        }

        if (direction.equals("left")) {
            coordinate = answer[0] - 1;
            return isValidXCoordinate(coordinate, board);
        }

        coordinate = answer[0] + 1;
        return isValidXCoordinate(coordinate, board);
    }

    private boolean isValidYCoordinate(int coordinate, int[] board) {
        return coordinate <= board[1] / 2 && coordinate >= -board[1] / 2;
    }

    private boolean isValidXCoordinate(int coordinate, int[] board) {
        return coordinate <= board[0] / 2 && coordinate >= -board[0] / 2;
    }

    private void move(int[] answer, String direction) {
        if (direction.equals("up")) {
            answer[1] += 1;
            return;
        }

        if (direction.equals("down")) {
            answer[1] -= 1;
            return;
        }

        if (direction.equals("left")) {
            answer[0] -= 1;
            return;
        }

        answer[0] += 1;
    }
}
