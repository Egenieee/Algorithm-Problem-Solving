package baekjoon.bronze.bronze_3.i_love_croatia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final int BOMB_MINUTE = 210;
    private static final int NUMBER_OF_PEOPLE = 8;
    private static final int FIRST_ORDER = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int currentNumber = Integer.parseInt(br.readLine());
        int numberOfQuestion = Integer.parseInt(br.readLine());
        int currentSpentTime = 0;

        for (int i = 0; i < numberOfQuestion; i++) {
            st = new StringTokenizer(br.readLine());

            int minute = Integer.parseInt(st.nextToken());
            String answer = st.nextToken();

            // 시간 지남
            currentSpentTime += minute;

            // 폭탄 터지는 시간 초과시 반복문 탈출 후 번호 리턴
            if (currentSpentTime >= BOMB_MINUTE) {
                break;
            }

            // 맞췄을 경우 다음사람에게 순서 넘어감
            if (answer.equals("T")) {
                currentNumber++;

                if (currentNumber > NUMBER_OF_PEOPLE) {
                    currentNumber = FIRST_ORDER;
                }
            }

            // 맞추지 못하거나 스킵했을 경우 같은 사람이 다음 질문 받음 -> 순서 유지
        }

        bw.write(String.valueOf(currentNumber));
        bw.close();
    }
}
