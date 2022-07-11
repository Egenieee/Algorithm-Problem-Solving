package etc.ss_selfcheck.no_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public static void main(String[] args) throws Exception {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++) {
            // 땅의 한 변 길이 받아오기
            int n = sc.nextInt();

            // 땅 채우자
            int[][] board = new int[n][n];
            sc.nextLine();

            for (int i = 0 ; i < n ; i++) {
                String str = sc.nextLine();
                st = new StringTokenizer(str);
                for (int j = 0 ; j < n ; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // bsf 시작 -> 답 구하기
            int maxAreaCount = getMaxAreaCount(board, n);

            // test case 마다 답 출력
            System.out.println("#" + test_case + " " + maxAreaCount);
        }
    }

    private static int getMaxAreaCount(int[][] board, int n) {
        int maxAreaCount = Integer.MIN_VALUE;

        // 현재부터 1년이 지남에 따라 변화하는 구역의 개수 구하기 -> 가장 많은 구역의 개수 구하기
        for (int curYear = 0 ; true ; curYear++) {
            int areaCount = getAreaCount(board, n, curYear);

            //System.out.println(curYear+"년 뒤, 구역의 개수 : " + areaCount);

            if (maxAreaCount < areaCount) {
                maxAreaCount = areaCount;
            }

            // 모두 물에 잠기면 반복문 종료
            if (areaCount == 0) {
                break;
            }
        }

        return maxAreaCount;
    }

    private static int getAreaCount(int[][] board, int n, int curYear) {
        // 방문여부를 표시하기 위한 배열
        boolean[][] visited = new boolean[n][n];

        // 상하좌우 값을 계산하기 위한 배열
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int countOfArea = 0;

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j++) {
                // 현재 보고 있는 땅이 물에 잠기었거나 이미 방문한 땅이면 bfs 시작 안함
                if (board[i][j] <= curYear || visited[i][j]) {
                    continue;
                }

                // bfs 시작 -> 구역의 개수 하나 증가
                countOfArea++;

                // 현재 좌표 큐에 삽입
                queue.add(new Point(i, j));

                // 방문했다고 표시
                visited[i][j] = true;

                // 하나의 연결된 구역 찾는 반복문
                while (!queue.isEmpty()) {
                    // 큐에서 땅 하나 꺼내와서
                    Point curPoint = queue.poll();

                    // 하, 우, 상, 좌의 땅을 살펴본다.
                    for (int dir = 0 ; dir < 4 ; dir++) {
                        int nX = curPoint.getX() + dx[dir];
                        int nY = curPoint.getY() + dy[dir];

                        // nX와 nY가 땅 범위 밖으로 넘어갔다면 패스
                        if (nX < 0 || nX >= n || nY < 0 || nY >= n ) {
                            continue;
                        }

                        // 방문하지 않았고, 물에 잠기지 않은 땅이라면 큐에 넣는다.
                        if (visited[nX][nY] || board[nX][nY] <= curYear) {
                            continue;
                        }

                        visited[nX][nY] = true;
                        queue.add(new Point(nX, nY));
                    }
                }
            }
        }

        return countOfArea;
    }
}