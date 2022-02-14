package leetcode.add_binary;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addBinary("11", "1");
    }
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();

        int idxOfOne = a.length() - 1; //a의 인덱스 번호 구하기
        int idxOfTwo = b.length() - 1; //b의 인덱스 번호 구하기
        int addBinary = 0; //올림 수 변수 선언

        while(idxOfOne >= 0 || idxOfTwo >= 0) { //둘 중 하나가 끝나더라도, 남은 스트링까지 반복하는 조건문
            int value = addBinary; // 올림 수를 추가함.
            if(idxOfOne >= 0) {
                value += a.charAt(idxOfOne--) - '0'; //-'0' 하는 이유는 진짜 숫자를 구하기 위함. "1" -> 1로 만드는 과정
            }                                        // 숫자로 바꿔서 value에 더한 뒤 인덱스 번호 앞으로 옮김
            if(idxOfTwo >= 0) {
                value += b.charAt(idxOfTwo--) - '0';
            }

            if(value > 1) { //더한 수가 2 이상이면
                value -= 2; //value에서 2를 뺀 후,
                addBinary = 1; //올림 수를 1로 바꿈
            } else { // 그렇지 않으면
                addBinary = 0; //올림 수는 0
            }
            stringBuilder.append(value); //한 자리수의 연산을 끝낸 후 stringbuilder에 스트링 추가. 뒤에 하나 씩 붙는다.
        }

        if(addBinary > 0) { //연산을 모두 다 끝낸 뒤 올림 수가 남아 있으면
            stringBuilder.append(addBinary); // 맨 뒤에 붙인다.
        }

        System.out.println(stringBuilder.reverse().toString());

        return stringBuilder.reverse().toString(); //스트링이 끝에 하나씩 붙었기 때문에 거꾸로 돌려서 반환한다.
    }
}

//Input: a = "11", b = "1"
//Output: "100"

//Input: a = "1010", b = "1011"
//Output: "10101"