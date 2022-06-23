package programmers.num_string_and_english_word;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("one4seveneight"));
    }
    public int solution(String s) {
        int answer = 0;

        String[] words = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numbers = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

        for(int i = 0 ; i < 10 ; i++) {
            s = s.replace(words[i], numbers[i]);
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
