package programmers.level_2.n_queen;

public class Solution {
    static boolean[] rowColumnUsed;
    static boolean[] leftDownToRightTopUsed;
    static boolean[] rightDownToLeftTopUsed;

    static int count = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3));
    }

    public int solution(int n) {
        // 해당 열에 퀸이 존재하는 지 나타내기 위한 배열
        rowColumnUsed = new boolean[n];
        // 좌하단 - 우상단 대각선에 퀸이 존재하는 지 나타내기 위한 배열
        leftDownToRightTopUsed = new boolean[n * 2 - 1];
        // 우하단 - 좌상단 대각선에 퀸이 존재하는 지 나타내기 위한 배열
        rightDownToLeftTopUsed = new boolean[n * 2 - 1];

        nQueen(0, n);

        return count;
    }

    private void nQueen(int curNumber, int n) {
        if (curNumber == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 현재 체스보드에 퀸을 놓을 수 있는지 없는지 판단하는 조건문
            if (rowColumnUsed[i] || leftDownToRightTopUsed[i + curNumber] || rightDownToLeftTopUsed[curNumber - i + n - 1]) {
                continue;
            }

            // 퀸을 놓을 수 있다면, 해당 열, 대각선에 퀸을 놓았다고 표시한다
            rowColumnUsed[i] = true;
            leftDownToRightTopUsed[i + curNumber] = true;
            rightDownToLeftTopUsed[curNumber - i + n - 1] = true;

            // 퀸을 놓은 후 다음 퀸을 놓기 위해 재귀함수 호출
            nQueen(curNumber + 1, n);

            // 퀸을 더 이상 놓지 못하면 퀸을 빼자 !
            rowColumnUsed[i] = false;
            leftDownToRightTopUsed[i + curNumber] = false;
            rightDownToLeftTopUsed[curNumber - i + n - 1] = false;
        }
    }
}
