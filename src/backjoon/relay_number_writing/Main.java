package backjoon.relay_number_writing;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        int standardNumber = 0;
        int pointer = 0;
        int makeNumber = 0;

        int previousNumber = N.charAt(pointer) - '0'; // 2
        System.out.println("makeNumber : " + previousNumber);

        N = N.substring(pointer + 1);

        // 234082
        // 2, 3, 4, 10, 18, 20

        // 32098221 -> 61
        // 82340329923 -> 43
        // 1111111 -> 14
        // 234092 -> 20
        // 345029834023049820394802334909240982039842039483294792934790209 -> 279
        // 00000000000000000000000000000000000000000000000000000000000000000000000 -> 400

        while (pointer < N.length()) {
            int currentNumber;
            int digitLength = getDigitLength(standardNumber);

            // 자릿수가 한 자리가 아닐 경우
            if (digitLength > 1) {
                // 남은 숫자 사이즈가 자리수보다 작거나 같은 경우
                if (N.length() <= digitLength) {
                    currentNumber = Integer.parseInt(N);
                } else {
                    String subString = N.substring(0, digitLength);
                    if (subString.charAt(0) == '0') { // 자리수 중 첫번째 숫자가 0이면 맨 앞만 가져옴
                        currentNumber = N.charAt(0) - '0';
                    } else {// 아닐 경우 일단 다 가져옴
                        currentNumber = Integer.parseInt(subString);
                    }
                }
            } else { // 자릿수가 한 자리 일 경우
                currentNumber = N.charAt(0) - '0'; // 3
            }

            // 한 자리수가 아니고, 2자리 수 이상이지만 standardNumber와 비교해서 십의 자리가 위일 경우
            if ((standardNumber > 0) && (getTenDigit(currentNumber) > getTenDigit(standardNumber))) {
                currentNumber = N.charAt(0) - '0';
            }

            if (previousNumber > currentNumber) {
                currentNumber = N.charAt(0) - '0';
            }

            // 전 숫자와 십의 자리가 같고, 일의 자리가 같은 경우는? 십의 자리만 남겨졌다는 것?
//            if ((getTenDigit(previousNumber) == getTenDigit(currentNumber)) && (previousNumber % 10 == currentNumber % 10)) {
//                currentNumber = (previousNumber % 10) + 1;
//            }

            // 감소하거나 변화 없으면 기준 십의자리보다 + 10 해주고
            // 전의 숫자의 일의 자리이랑만 비교해야 하나?
            if ((previousNumber % 10) >= (currentNumber % 10)) {
                standardNumber += 10;
            }

            // 증가하는 경우는 기준 숫자 그대로
            if (String.valueOf(standardNumber).contains(String.valueOf(currentNumber)) && (previousNumber != standardNumber)) {
                makeNumber = standardNumber;
            } else if (currentNumber / 10 > 0) {
                makeNumber = currentNumber;
            } else {
                makeNumber = standardNumber + currentNumber;
            }

            previousNumber = makeNumber;
            N = N.substring(getDigitLength(currentNumber));
            System.out.println("makeNumber : " + makeNumber);
        }

        System.out.println();
        bw.write(String.valueOf(makeNumber));
        bw.flush();
        bw.close();
    }

    private static int getTenDigit(int number) {
        return (number / 10);
    }

    private static int getDigitLength(int standardNumber) {
        return String.valueOf(standardNumber).length();
    }
}
