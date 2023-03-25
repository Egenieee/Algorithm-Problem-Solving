package programmers.level_1.deck_of_cards;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        for (String goalCard : goal) {
            if (haveGoalCard(goalCard, cards1)) {
                getCardsResult(goalCard, cards1);
            } else if (haveGoalCard(goalCard, cards2)) {
                getCardsResult(goalCard, cards2);
            } else {
                return "No";
            }
        }

        return "Yes";
    }

    private boolean haveGoalCard(String goalCard, String[] cards) {
        for (String card : cards) {
            if (!card.equals("")) {
                return card.equals(goalCard);
            }
        }

        return false;
    }

    private void getCardsResult(String goalCard, String[] cards) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(goalCard)) {
                cards[i] = ""; // 사용한 카드는 ""으로 처리
                return;
            }
        }
    }
}
