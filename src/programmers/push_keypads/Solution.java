package programmers.push_keypads;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    Hand leftHand = new Hand(3, 0);
    Hand rightHand = new Hand(3, 2);

    // RLRLRLLRRLL

    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.solution(new int[]{0, 1, 0, 2, 3, 2, 0, 2, 3, 0, 4}, "right");
        System.out.println(answer);
    }
    public String solution(int[] numbers, String hand) {

        StringBuilder answer = new StringBuilder();

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                leftHand.changeHand(getHandCoordinates(number));
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                rightHand.changeHand(getHandCoordinates(number));
            } else { // 2470인 경우 더 가까운 손가락으로 누르되, 거리 같다면, 잡이 따짐
                answer.append(getPushingHand(number, hand));
            }
        }

        return answer.toString();
    }

    private String getPushingHand(int number, String hand) {
        List<Integer> coordinates = getHandCoordinates(number);

        int leftHandDistance = leftHand.getDistanceFromKey(coordinates);
        int rightHandDistance = rightHand.getDistanceFromKey(coordinates);

        if (leftHandDistance < rightHandDistance) {
            leftHand.changeHand(coordinates);
            return "L";
        }

        if (leftHandDistance > rightHandDistance) {
            rightHand.changeHand(coordinates);
            return "R";
        }

        if (hand.equals("right")) {
            rightHand.changeHand(coordinates);
            return "R";
        }

        leftHand.changeHand(coordinates);
        return "L";
    }

    // 1    2   3   [0,0]   [0,1]   [0,2]
    // 4    5   6   [1,0]   [1,1]   [1,2]
    // 7    8   9   [2,0]   [2,1]   [2,2]
    // *    0   #   [3,0]   [3,1]   [3,2]

    private List<Integer> getHandCoordinates(int number) {
        List<Integer> coordinates = new ArrayList<>();

        if (number == 0) {
            coordinates.add(3);
            coordinates.add(1);
            return coordinates;
        }

        coordinates.add((number - 1) / 3); // x 좌표
        coordinates.add((number - 1) % 3); // y 좌표

        return coordinates;
    }

    public class Hand {
        int x;
        int y;

        public Hand (int initX, int initY) {
            this.x = initX;
            this.y = initY;
        }

        public void changeHand(List<Integer> coordinates) {
            this.x = coordinates.get(0);
            this.y = coordinates.get(1);
        }

        public int getDistanceFromKey(List<Integer> coordinates) {
            int targetNumberX = coordinates.get(0);
            int targetNumberY = coordinates.get(1);

            return Math.abs(x - targetNumberX) + Math.abs(y - targetNumberY);
        }
    }
}

