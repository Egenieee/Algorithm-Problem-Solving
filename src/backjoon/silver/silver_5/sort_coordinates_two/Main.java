package backjoon.silver.silver_5.sort_coordinates_two;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
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
            if (y == o.getY()) {
                return x - o.getX();
            }

            return y - o.getY();
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
