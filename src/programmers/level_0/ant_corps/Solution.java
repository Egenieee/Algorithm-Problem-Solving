package programmers.level_0.ant_corps;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(999));
    }

    public int solution(int hp) {
        int totalAntNumber = 0;

        int[] ants = new int[]{1, 3, 5};

        totalAntNumber += hp / ants[2];
        hp %= ants[2];

        totalAntNumber += hp / ants[1];
        hp %= ants[1];

        totalAntNumber += hp / ants[0];

        return totalAntNumber;
    }
}
