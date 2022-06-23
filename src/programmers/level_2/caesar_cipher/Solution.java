package programmers.level_2.caesar_cipher;

public class Solution {
    public static final int ALPHABET_COUNT = 26;
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("a F G", 25);
        System.out.println(result);
    }
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0 ; i < s.length() ; i++) {
            char alphabet = s.charAt(i);
            int swiftedAlphabet = alphabet + n;

            if (alphabet == ' ') {
                answer.append(alphabet);
            } else {
                if (alphabet <= 'Z' && alphabet >= 'A') {
                    if (swiftedAlphabet > 'Z') {
                        answer.append((char) (alphabet - ALPHABET_COUNT + n));
                    } else {
                        answer.append((char) (alphabet + n));
                    }
                } else {
                    if (swiftedAlphabet > 'z') {
                        answer.append((char) (alphabet - ALPHABET_COUNT + n));
                    } else {
                        answer.append((char) (alphabet + n));
                    }
                }
            }
        }
        return answer.toString();
    }
}
