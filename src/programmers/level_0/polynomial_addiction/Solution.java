package programmers.level_0.polynomial_addiction;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("20"));
    }

    public String solution(String polynomial) {
        String[] polynomials = polynomial.split(" ");

        int totalX = 0;
        int constant = 0;

        for (String element : polynomials) {
            if (isX(element)) {
                totalX += addX(element);
            }

            if (isConstance(element)) {
                constant += Integer.parseInt(element);
            }
        }

        return getAnswer(totalX, constant);
    }

    private boolean isX(String element) {
        return element.contains("x");
    }

    private boolean isConstance(String element) {
        return !element.equals("+") && !element.contains("x");
    }

    private int addX(String element) {
        if (element.length() == 1) {
            return 1;
        }

        element = element.substring(0, element.length() - 1);

        return Integer.parseInt(element);
    }

    private String getAnswer(int totalX, int constant) {
        String xAnswer = getX(totalX);
        String constantAnswer = String.valueOf(constant);

        if (totalX == 0) {
            return constantAnswer;
        }

        if (constant == 0) {
            return xAnswer;
        }

        return xAnswer + " + " + constantAnswer;
    }

    private String getX(int totalX) {
        if (totalX == 1) {
            return "x";
        }

        return totalX + "x";
    }
}
