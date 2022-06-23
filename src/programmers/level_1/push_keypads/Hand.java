package programmers.level_one.push_keypads;

import java.util.List;

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
