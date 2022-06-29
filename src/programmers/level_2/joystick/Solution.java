package programmers.level_2.joystick;

public class Solution {
    public static final int CHAR_TO_NUMBER = 65;
    public static final int ALPHABET_COUNT = 26;
    public static final int MIN_COUNT_STANDARD = 13;

    int pointer = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("AAAAA"));
    }

    public int solution(String name) {
        int countOfChange = 0;
        int countOfStickMoveRight = 0;
        int countOfStickMoveLeft = 0;
        int countToChange = getCountToChange(name);

        if (countToChange == 0) {
            return countOfStickMoveRight;
        }

        boolean directionToRight = true;
        char currentLetter;

        // 오른쪽 방향으로 갔을 때
        while (true) { // 바꾼 알파벳 개수 == 바꿀 알파벳 개수 일치하면 반복문에서 빠져나옴
            currentLetter = name.charAt(pointer);

            if (currentLetter != 'A') {
                countOfStickMoveRight += getMinCount(currentLetter);
                countOfChange++;
            }

            if (countToChange == countOfChange) {
                break;
            }

            movePointer(directionToRight);
            countOfStickMoveRight++;
        }

        // 왼쪽 방향으로 갔을 때
        countOfChange = 0;

        // 맨 처음 글자 변경
        pointer = 0;
        currentLetter = name.charAt(pointer);
        countOfStickMoveLeft += getMinCount(currentLetter);
        countOfChange++;

        // 맨 끝으로 커서 이동
        pointer = name.length() - 1;
        countOfStickMoveLeft++;
        directionToRight = false;

        while (true) { // 바꾼 알파벳 개수 == 바꿀 알파벳 개수 일치하면 반복문에서 빠져나옴
            currentLetter = name.charAt(pointer);

            if (currentLetter != 'A') {
                countOfStickMoveLeft += getMinCount(currentLetter);
                countOfChange++;
            }

            if (countToChange == countOfChange) {
                break;
            }

            movePointer(directionToRight);
            countOfStickMoveLeft++;
        }

        System.out.println("오른쪽 방향으로 갔을 때 : " + countOfStickMoveRight);
        System.out.println("왼쪽 방향으로 갔을 때 : " + countOfStickMoveLeft);

        return Math.min(countOfStickMoveRight, countOfStickMoveLeft);
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
