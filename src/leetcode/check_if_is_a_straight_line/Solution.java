package leetcode.check_if_is_a_straight_line;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.checkStraightLine(new int[][] {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}});
    }
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length <= 2) return true;

        int dy = coordinates[1][1] - coordinates[0][1]; //y 변화량
        int dx = coordinates[1][0] - coordinates[0][0]; //x 변화량

        for(int i = 1 ; i < coordinates.length - 1; i++){
            if(dy * (coordinates[i+1][0] - coordinates[i][0]) != dx * (coordinates[i+1][1] - coordinates[i][1])) {
                return false; //기울기 다르면 false
            }
        }

        return true;
    }
}
