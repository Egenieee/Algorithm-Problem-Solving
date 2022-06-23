package leetcode.easy.add_strings;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addStrings("11", "123");
    }
    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder(); //마치 벡터처럼 스트링을 붙여 사용할 수 있음

        int carryOver = 0; //올림수 나타내는 변수 선언
        int idxOfOne = num1.length() - 1; //첫번째 스트링의 맨 끝 인덱스 구하기
        int idxOfTwo = num2.length() - 1; //두번째 스트링의 맨 끝 인덱스 구하기

        while(idxOfOne >= 0 || idxOfTwo >= 0) { //둘 중 하나가 끝나더라도 나머지 하나가 다 끝날때까지 반복함
            int value = carryOver; //올림수 더해줌
            if(idxOfOne >= 0) { //인덱스가 -1이 아닐 경우
                value += num1.charAt(idxOfOne--) - '0'; //값에 스트링에 있는 수 더해줌. '0'을 빼야 actual number가 나온다
            }
            if(idxOfTwo >= 0) {
                value += num2.charAt(idxOfTwo--) - '0';
            }

            if(value > 9) { //10이상일 경우
                value -= 10; //10을 빼서 남는 수를 표기해준다.
                carryOver = 1; //올림수도 하나 올려준다.
            } else {
                carryOver = 0;
            }

            stringBuilder.append(value);
        }

        if(carryOver > 0) { //반복문을 모두 돈 후에 올림수가 남아 있으면
            stringBuilder.append(carryOver); //스트링빌더로 맨 앞에 붙여준다
        }

        String result = stringBuilder.reverse().toString(); //결과가 거꾸로 되어있기 때문에 reverse()해준다.
        System.out.println(result);

        return result;
    }
}
