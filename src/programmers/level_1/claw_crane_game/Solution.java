package programmers.level_1.claw_crane_game;

// 행 기준으로 격자 뒤지면서 0이 아닌 요소가 있다면 list에 차례대로 넣기
// 리스트에서 전과 같은 요소가 들어가면 전 요소와 현재 요소 없애고 터뜨린 인형 개수 증가

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},
                new int[]{1,5,3,5,1,2,1,4});
    }
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int picked;
        List<Integer> bucket = new ArrayList<>();

        for (int cranePosition : moves) {
            picked = pickOne(board, cranePosition);

            putInTheBucket(bucket, picked);

            answer += getPopCount(bucket);
        }

        return answer;
    }

    // board 확인 후 인형 하나 집어 옴.
    private int pickOne(int[][] board, int cranePosition) {
        int picked;
        for (int i = 0 ; i < board.length ; i++) {
            if (board[i][cranePosition - 1] != 0 ) {
                picked =  board[i][cranePosition - 1];
                board[i][cranePosition - 1] = 0;
                return picked;
            }
        }
        return -1;
    }

    // 제대로 된 인형이 나왔다면 바구니에 담아줌 턴
    private void putInTheBucket(List<Integer> bucket, int picked) {
        if (picked != -1) {
            bucket.add(picked);
        }
    }

    private int getPopCount(List<Integer> bucket) {
        int count = 0;
        if (bucket.size() > 1) {
            count = removePicked(bucket);
        }
        return count;
    }

    // 바구니 안에서 같은 요소 2개 담긴 거 확인 후에 제거 후에 없앤 만큼의 수 리턴
    private int removePicked(List<Integer> bucket) {
        int count = 0;
        if (bucket.get(bucket.size() - 1).equals(bucket.get(bucket.size() - 2))) {
            bucket.remove(bucket.size() - 1);
            bucket.remove(bucket.size() - 1);

            System.out.println("Pop");

            count += 2;
        }
        return count;
    }
}

