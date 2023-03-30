package programmers.level_1.food_fighter_competition;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 7, 1, 2}));
    }

    public String solution(int[] food) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int quotient = food[i] / 2;

            if (quotient != 0) {
                repeat(stringBuilder, quotient, i);
            }
        }

        String opposite = stringBuilder.toString();
        stringBuilder.append(0);
        stringBuilder.reverse();

        stringBuilder.insert(0, opposite);

        return stringBuilder.toString();
    }

    private void repeat(StringBuilder stringBuilder, int quotient, int food) {
        stringBuilder.append(String.valueOf(food).repeat(Math.max(0, quotient)));
    }
}
