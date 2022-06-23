package baekjoon.silver.silver_5.sort_number_two;

// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

// 힙 정렬을 구현해보자.

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sort(arr, arr.length);

        for (int j : arr) {
            bw.write(j + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void sort(int[] a, int size) {
        if (size < 2) {
            return;
        }

        // 가장 마지막 요소의 부모 노드 인덱스
        int parentIdx = getParent(size - 1);

        // 최대 힙 만들기
        for (int i = parentIdx ; i >= 0 ; i--) {
            heapify(a, i, size - 1);
        }

        // 정렬
        // root인 노드 인덱스와 i번째 인덱스 값을 swap한 뒤, 0 ~ (i-1) 까지의 부분트리에 대해 최대 힙을 만족하도록 재구성한다.
        for (int i = size - 1 ; i > 0 ; i--) {
            swap(a, 0, i);
            heapify(a, 0, i - 1);
        }
    }

    // 부모 노드 인덱스를 구하는 함수
    private static int getParent(int child) {
        return (child - 1) / 2;
    }

    // 두 인덱스의 원소를 교환하는 함수
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void heapify(int[] a, int parentIdx, int lastIdx) {
        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;

        while((parentIdx * 2) + 1 <= lastIdx) {
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            largestIdx = parentIdx;

            if (a[leftChildIdx] > a[largestIdx]) {
                largestIdx = leftChildIdx;
            }

            if ((rightChildIdx <= lastIdx) && (a[rightChildIdx] > a[largestIdx])) {
                largestIdx = rightChildIdx;
            }

            // 교환이 발생했을 경우 두 원소를 교체한 뒤 교환이 된 자식노드를 부모 노드가 되도록 교체한다.
            if (largestIdx != parentIdx) {
                swap(a, parentIdx, largestIdx);
                parentIdx = largestIdx;
            } else {
                return;
            }
        }
    }
}
