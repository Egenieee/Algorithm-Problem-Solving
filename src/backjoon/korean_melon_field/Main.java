package backjoon.korean_melon_field;

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

        List<Pair> inputField = new ArrayList<>();
        Set<Pair> subSet = new HashSet<>();

        for (int i = 0 ; i < 6 ; i++) {
            st = new StringTokenizer(br.readLine());

            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            inputField.add(new Pair(direction, length));
        }

        Set<Pair> subAreaSet = new HashSet<>(inputField);

        Pair maxHeight = getMaxHeight(inputField);
        Pair maxWidth = getMaxWidth(inputField);

        subSet.add(maxHeight);
        subSet.add(maxWidth);

        // 돌면서 가장 긴 h,w 인접 변 찾기
        for (int i = 0 ; i < inputField.size() ; i++) {
            Pair line = inputField.get(i);
            if (line == maxHeight) {
                saveLinePair(inputField, subSet, line);
            }

            if (line == maxWidth) {
                saveLinePair(inputField, subSet, line);
            }
        }

        subAreaSet.removeAll(subSet);

        int wholeArea = maxHeight.getLength() * maxWidth.getLength();
        int subArea = getSubArea(subAreaSet);

        wholeArea -= subArea;

        countOfMelon = wholeArea * countPerOneSquaredMeter;

        bw.write(String.valueOf(countOfMelon));
        bw.flush();
        bw.close();
    }

    private static Pair getMaxHeight(List<Pair> inputField) {
        int maxHeight = Integer.MIN_VALUE;

        Pair maxHeightPair = null;

        for (Pair pair : inputField) {
            if (pair.getDirection() == 1 || pair.getDirection() == 2) {
                continue;
            }

            if (pair.getLength() > maxHeight) {
                maxHeight = pair.getLength();
                maxHeightPair = pair;
            }
        }

        return maxHeightPair;
    }

    private static Pair getMaxWidth(List<Pair> inputField) {
        int maxWidth = Integer.MIN_VALUE;

        Pair maxWidthPair = null;

        for (Pair pair : inputField) {
            if (pair.getDirection() == 3 || pair.getDirection() == 4) {
                continue;
            }

            if (pair.getLength() > maxWidth) {
                maxWidth = pair.getLength();
                maxWidthPair = pair;
            }
        }

        return maxWidthPair;
    }

    private static void saveLinePair(List<Pair> inputField, Set<Pair> subSet, Pair line) {
        int idx = inputField.indexOf(line);

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

    private static int getSubArea(Set<Pair> subAreaSet) {
        int subArea = 1;

        for (Pair pair : subAreaSet) {
            subArea *= pair.getLength();
        }

        return subArea;
    }
}
