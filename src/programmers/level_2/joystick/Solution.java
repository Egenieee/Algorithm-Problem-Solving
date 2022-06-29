package programmers.level_2.joystick;

public class Solution {
    public static final int CHAR_TO_NUMBER = 65;
    public static final int ALPHABET_COUNT = 26;
    public static final int MIN_COUNT_STANDARD = 13;

    int pointer = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("GTAS"));
    }

    public int solution(String name) {
        int countOfChange = 0;
        int countOfStickMove = 0;
        int countToChange = getCountToChange(name);

        boolean directionToRight = true;
        char currentLetter = name.charAt(pointer);

        // 두번째 글자가 A일 경우
        if (name.charAt(pointer + 1) == 'A') {
            countOfStickMove += getMinCount(currentLetter);

            if (currentLetter != 'A') {
                countOfChange++;
            }

            directionToRight = false;

            pointer = name.length() - 1;
            countOfStickMove++;
        }

        while (true) { // 바꾼 알파벳 개수 == 바꿀 알파벳 개수 일치하면 반복문에서 빠져나옴
            currentLetter = name.charAt(pointer);

            if (currentLetter != 'A') {
                countOfStickMove += getMinCount(currentLetter);
                countOfChange++;
            }

            if (countToChange == countOfChange) {
                break;
            }

            movePointer(directionToRight);
            countOfStickMove++;
        }

        return countOfStickMove;
    }

    private int getCountToChange(String name) {
        int countToChange = 0;

        for (int i = 0 ; i < name.length() ; i++) {
            if (name.charAt(i) != 'A') {
                countToChange++;
            }
        }

        return countToChange;
    }

    private int getMinCount(char currentLetter) {
        int alphabetNumber = currentLetter - CHAR_TO_NUMBER;
        int reverseNumber = ALPHABET_COUNT - alphabetNumber;

        if (reverseNumber > MIN_COUNT_STANDARD) { // 알파벳 번호가 앞쪽인 경우
            return alphabetNumber;
        } else { // 뒷쪽인 경우
            return reverseNumber;
        }
    }

    private void movePointer(boolean directionRight) {
        if (directionRight) {
            pointer++;
        } else {
            pointer--;
        }
    }
}
