package programmers.level_1.minimum_rectangle;

// [[60, 50], [30, 70], [60, 30], [80, 40]]	4000
//[[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
//[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}});
        System.out.println(answer);
    }

    public int solution(int[][] sizes) {
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        // 가로 < 세로 면 스왑해주자
        for (int[] card : sizes) {
            if (card[0] < card[1]) {
                int temp = card[0];
                card[0] = card[1];
                card[1] = temp;
            }
        }

        for (int[] card : sizes) {
            if (card[0] > maxWidth) {
                maxWidth = card[0];
            }

            if (card[1] > maxHeight) {
                maxHeight = card[1];
            }
        }


        return maxWidth * maxHeight;
    }
}
