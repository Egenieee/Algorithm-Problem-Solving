package programmers.push_keypads;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[][] keypads = getKeypads();
    Hand leftHand = new Hand(3, 0);
    Hand rightHand = new Hand(3, 2);

    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
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
                String pushingHand = getPushingHand(number, hand);
                answer.append(pushingHand);
            }
        }

        return answer.toString();
    }

    private String getPushingHand(int number, String hand) {
        int leftHandDistance = leftHand.getDistanceFromKey(getHandCoordinates(number));
        int rightHandDistance = rightHand.getDistanceFromKey(getHandCoordinates(number));

        if (leftHandDistance < rightHandDistance) {
            leftHand.changeHand(getHandCoordinates(number));
            return "L";
        }

        if (leftHandDistance > rightHandDistance) {
            rightHand.changeHand(getHandCoordinates(number));
            return "R";
        }

        if (hand.equals("right")) {
            rightHand.changeHand(getHandCoordinates(number));
            return "R";
        }

        leftHand.changeHand(getHandCoordinates(number));
        return "L";
    }

    private List<Integer> getHandCoordinates(int number) {
        List<Integer> coordinates = new ArrayList<>();

        for (int i = 0 ; i < keypads.length ; i++) {
            for (int j = 0 ; j < keypads[0].length ; j++) {
                if (keypads[i][j] == number) {
                    coordinates.add(i);
                    coordinates.add(j);
                    return coordinates;
                }
            }
        }

        return null;
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

    private static int[][] getKeypads() {
        int[][] keypads = new int[4][3];

        int number = 1;

        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                keypads[i][j] = number;
                number++;
            }
        }

        keypads[3][0] = -1;
        keypads[3][1] = 0;
        keypads[3][2] = -1;

        return keypads;
    }
}

