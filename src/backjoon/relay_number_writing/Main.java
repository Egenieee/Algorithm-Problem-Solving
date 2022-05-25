package backjoon.relay_number_writing;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int standardNumber = 1;
        int pointer = 0;

        // 234082
        // 2, 3, 4, 10, 18, 20

        // 32098221 -> 61
        // 82340329923 -> 43
        // 1111111 -> 14
        // 234092 -> 20
        // 345029834023049820394802334909240982039842039483294792934790209 -> 279
        // 00000000000000000000000000000000000000000000000000000000000000000000000 -> 400

        Loop :
        while (pointer != input.length()) {
            String standardNumberString = String.valueOf(standardNumber);

            // 기준이 되는 숫자 하나씩 현재 포인터가 가르키고 있는 숫자와 매칭되는 지 확인하기
            for (int i = 0 ; i < standardNumberString.length() ; i++) {
                if (input.charAt(pointer) == standardNumberString.charAt(i)) {
                    //System.out.println("makeNumber : " + standardNumber);
                    pointer++;
                }
                if (pointer == input.length()) {
                    break Loop;
                }
            }

            standardNumber++;
        }

        bw.write(String.valueOf(standardNumber));
        bw.flush();
        bw.close();
    }
}
