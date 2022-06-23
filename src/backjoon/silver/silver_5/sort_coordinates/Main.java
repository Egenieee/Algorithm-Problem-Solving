package backjoon.silver.silver_5.sort_coordinates;

// 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

// 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
// (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 내부 static class를 인스턴스화할 때 외부 클래스에 대한 인스턴스가 굳이 필요 없다.
    // 따라서 내부 클래스를 정의할 때는 'static' 키워드를 붙여주자.
    static class Point implements Comparable<Point> {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String getPair() {
            return x + " " + y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Point o) {
            if (x == o.getX()) {
                return y - o.getY();
            }

            return x - o.getX();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Point> points = new LinkedList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(points);

        for (Point point : points) {
            bw.write(point.getPair() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
