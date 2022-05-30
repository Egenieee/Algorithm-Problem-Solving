package programmers.next_large_number;

// 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
//
//조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
//조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
//조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
//예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
//
//자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

// 78 -> 83
// 15 -> 23

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(15));
    }
    public int solution(int n) {
        int plus = 1;
        int largeNumber;
        String inputToBinary;
        String outputToBinary;

        while (true) {
            inputToBinary = Integer.toBinaryString(n);
            largeNumber = n + plus;
            outputToBinary = Integer.toBinaryString(largeNumber);

            if (isSameOneCount(inputToBinary, outputToBinary)) {
                break;
            }

            plus++;
        }

        return largeNumber;
    }

    private boolean isSameOneCount(String inputToBinary, String outputToBinary) {
        int inputOneCount = 0;
        int outputOneCount = 0;
        int idxOfInput = 0;
        int idxOfOutput = 0;

        while(idxOfInput < inputToBinary.length() || idxOfOutput < outputToBinary.length()) {
            if (idxOfInput < inputToBinary.length()) {
                if (inputToBinary.charAt(idxOfInput) == '1') {
                    inputOneCount++;
                }
            }

            if (idxOfOutput < outputToBinary.length()) {
                if(outputToBinary.charAt(idxOfOutput) == '1') {
                    outputOneCount++;
                }
            }

            idxOfInput++;
            idxOfOutput++;
        }

        return inputOneCount == outputOneCount;
    }
}
