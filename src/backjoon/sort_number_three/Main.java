package backjoon.sort_number_three;

// counting sort 알고리즘을 이용해보자.
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] inputNumbers = new int[N];
        int[] count = new int[10001];
        int[] sorted = new int[N];

        // input 배열에 수 하나 씩 넣기
        for (int i = 0 ; i < N ; i++){
            inputNumbers[i] = Integer.parseInt(br.readLine());
        }

        // 배열의 수 카운팅하기
        for (int i = 0 ; i < N ; i++) {
            count[inputNumbers[i]]++;
        }

        // 카운트 배열 누적합 시키기
        for (int i = 1 ; i < count.length ; i++) {
            count[i] += count[i - 1];
        }

        // 본 배열의 맨 끝에서 부터 보면서 (stable 정렬을 위해) 카운트 배열에서 idx 값 얻어서 새로운 sorted 배열에 착착 넣자.
        for (int i = N - 1 ; i >= 0 ; i--) {
            int idx = count[inputNumbers[i]] - 1;
            sorted[idx] = inputNumbers[i];
            count[inputNumbers[i]]--;
        }

        for (int i = 0 ; i < N ; i++) {
            bw.write(sorted[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
