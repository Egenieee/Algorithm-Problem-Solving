package programmers.level_0.print_age;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(40));
    }

    public int solution(int age) {
        return 2022 - age + 1;
    }
}
