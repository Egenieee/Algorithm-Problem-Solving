package programmers.level_2.lifeboat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{90, 80, 70, 40, 60, 30, 30, 20}, 100));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        List<Integer> sortedPeople = getSortedPeople(people);

        while (sortedPeople.size() > 0) {
            int savedPeopleCount = getSavedPeopleCount(sortedPeople, limit);

            if (savedPeopleCount > 0) {
                answer++;
            }
        }

        return answer;
    }

    private List<Integer> getSortedPeople(int[] people) {
        Arrays.sort(people);
        List<Integer> sortedPeople = new ArrayList<>();

        for (int i = people.length - 1; i >= 0; i--) {
            sortedPeople.add(people[i]);
        }

        return sortedPeople;
    }

    private int getSavedPeopleCount(List<Integer> people, int limit) {
        int currentPerson = people.get(0);

        int savedPeopleCount = 1;

        for (int i = 1; i < people.size(); i++) {
            if (currentPerson + people.get(i) <= limit) {
                savedPeopleCount++;
                people.remove(i);
                people.remove(0);
                return savedPeopleCount;
            }
        }

        people.remove(0);
        return savedPeopleCount;
    }
}
