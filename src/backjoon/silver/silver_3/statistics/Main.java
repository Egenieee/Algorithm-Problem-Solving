package backjoon.silver.silver_3.statistics;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 평균 소수점 이하 첫째자리에서 반올림한 값 출력
        int mean =  getMean(numbers);

        // 중앙값
        int median = getMedian(numbers);

        // 최빈값 --> 여러개면 두번째로 작은 값
        int mode = getMode(numbers);

        // 범위
        int range = getRange(numbers);

        bw.write(mean + "\n" + median + "\n" + mode + "\n" + range);
        bw.flush();
        bw.close();
    }

    private static int getMean(int[] numbers) {
        double sum = 0.0;

        for (int number : numbers) {
            sum += number;
        }

        return (int) Math.round(sum / numbers.length);
    }

    private static int getMedian(int[] numbers) {
        int medianIdx = numbers.length / 2;
        Arrays.sort(numbers);

        return numbers[medianIdx];
    }

    private static int getMode(int[] numbers) {
        Map<Integer, Integer> mode = new HashMap<>();

        for (int number : numbers) {
            mode.put(number, mode.getOrDefault(number, 0) + 1);
        }

        // value 값으로 정렬
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(mode.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        // 맨 위에 있는 게 최빈값인데, 최빈값이 같은 수가 또 있다면 두 수 중에 더 작은게 최빈값이 된다.
        // 최빈값이 하나인지 여러개인지 확인하는 로직
        if (mode.size() > 1) {
            return getMoreThanTwoMode(entryList);
        }

        return entryList.get(0).getKey();
    }

    private static int getMoreThanTwoMode(List<Map.Entry<Integer, Integer>> entryList) {
        int max = entryList.get(0).getValue();

        List<Integer> modeNumbers = new LinkedList<>();

        for (Map.Entry<Integer, Integer> number : entryList) {
            if (max == number.getValue()) {
                modeNumbers.add(number.getKey());
            }
        }

        Collections.sort(modeNumbers);

        if (modeNumbers.size() == 1) {
            return modeNumbers.get(0);
        }

        return modeNumbers.get(1);
    }

    private static int getRange(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int number : numbers) {
            if (max < number) {
                max = number;
            }
        }

        for (int number : numbers) {
            if (min > number) {
                min = number;
            }
        }

        return max - min;
    }
}
