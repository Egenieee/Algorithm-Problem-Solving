package baekjoon.silver.silver_3.korean_melon_field;

// Pair로 Set에 저장
// 가장 긴 h,w 구해서 인접 변 삭제하기

import java.io.*;
import java.util.*;

public class Main {
    public static class Pair {
        private final int direction;
        private final int length;

        public Pair(int direction, int length) {
            this.direction = direction;
            this.length = length;
        }

        public int getDirection() {
            return direction;
        }

        public int getLength() {
            return length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int countPerOneSquaredMeter = Integer.parseInt(br.readLine());
        int countOfMelon;

        int maxHeight = Integer.MIN_VALUE;
        int maxWidth = Integer.MIN_VALUE;

        int maxHeightIdx = 0;
        int maxWidthIdx = 0;

        List<Pair> inputField = new ArrayList<>();
        Set<Pair> subSet = new HashSet<>();

        for (int idx = 0 ; idx < 6 ; idx++) {
            st = new StringTokenizer(br.readLine());

            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            Pair line = new Pair(direction, length);

            if ((direction == 1 || direction == 2) && (maxWidth < length)) {
                maxWidth = length;
                maxWidthIdx = idx;
            }

            if ((direction == 3 || direction == 4) && (maxHeight < length)) {
                maxHeight = length;
                maxHeightIdx = idx;
            }

            inputField.add(line);
        }

        Set<Pair> subAreaSet = new HashSet<>(inputField);

        saveSafeLine(inputField, subSet, maxHeightIdx);
        saveSafeLine(inputField, subSet, maxWidthIdx);

        subAreaSet.removeAll(subSet);

        countOfMelon = getCountOfMelon(subAreaSet, maxHeight, maxWidth, countPerOneSquaredMeter);

        bw.write(String.valueOf(countOfMelon));
        bw.flush();
        bw.close();
    }

    private static void saveSafeLine(List<Pair> inputField, Set<Pair> subSet, int idx) {
        if (idx == 0) {
            subSet.add(inputField.get(inputField.size() - 1));
            subSet.add(inputField.get(idx + 1));
        } else if (idx == 5) {
            subSet.add(inputField.get(idx - 1));
            subSet.add(inputField.get(0));
        } else {
            subSet.add(inputField.get(idx - 1));
            subSet.add(inputField.get(idx + 1));
        }
    }

    private static int getCountOfMelon(Set<Pair> subAreaSet, int maxHeight,int maxWidth, int countPerOneSquaredMeter) {
        int wholeArea = maxHeight * maxWidth;
        int subArea = getSubArea(subAreaSet);

        wholeArea -= subArea;

        return wholeArea * countPerOneSquaredMeter;
    }

    private static int getSubArea(Set<Pair> subAreaSet) {
        int subArea = 1;

        for (Pair pair : subAreaSet) {
            subArea *= pair.getLength();
        }

        return subArea;
    }
}