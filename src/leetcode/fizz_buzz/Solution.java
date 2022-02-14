package leetcode.fizz_buzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fizzBuzz(15);
    }
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        int count = 1; //리스트는 0번 인덱스부터 시작이지만, 담는 수는 1부터 시작이기 때문에 count 변수를 선언하고 1부터 시작한다.
        //1번부터 시작하는 리스트라고 생각하자

        for(int i = 0 ; i < n ; i++) {
            if((count % 3 == 0) && (count % 5 == 0)) { //3과 5로 나누어지는 수에 해당하는 인덱스(1부터 시작하는 리스트의 인덱스)에는
                answer.add(i, "FizzBuzz"); //FizzBuzz를 추가한다.
                count++; //그리고 나서 count수 증가
            } else if(count % 5 == 0) { //똑같이 5로 나누어지는 수에는 Buzz추가
                answer.add(i, "Buzz");
                count++;
            } else if ((count % 3 == 0)) { //3으로 나누어지는 수에는 Fizz를 추가한다.
                answer.add(i, "Fizz");
                count++;
            }else { //3과 5로 모두 나누어지지 않는 수에는 count를 추가한다.
                answer.add(i, "" + count + "");
                count++;
            }
        }

        for(String num : answer) {
            System.out.print(num + " ");
        }

        return answer;
    }
}

//Input: n = 5
//Output: ["1","2","Fizz","4","Buzz"]
