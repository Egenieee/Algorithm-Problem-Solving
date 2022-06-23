package programmers.level_two.menu_renewal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
//["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
//["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]

// 한 사람이 주문한 메뉴가지고 코스 개수로 가능한 조합 만들어서 조합 카운팅하기.
// 다 넣은 뒤엔 메뉴 개수(course)에 따라 가장 많이 시킨 세트만 골라내야한다. 그리고 2회 이상 주문된 메뉴를 골라야한다.
// 하지만, 같은 횟수로 가장 많이 시킨 세트라면 다 담자.

public class Solution {
    Map<String, Integer> menusCombination = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> answer = solution.solution(new String[] {"XYZ", "XWY", "WXA"}, new int[]{2,3,4});
        for (String menu : answer) {
            System.out.println(menu);
        }
    }
    public List<String> solution(String[] orders, int[] course) {
        // 한 사람이 시킨 메뉴 마다 가능한 음식 조합 구해서 카운팅
        for (String order : orders) {
            String sortedOrder = getSortedOrder(order);
            countMenuCombination(sortedOrder, course);
        }

        // 맵에서 코스 크기에 맞는 조합 세트 중에서 가장 많이 주문된 세트의 주문횟수 구하기
        List<Integer> maxOrderCount = getMaxOrderCount(course);

        // 코스마다 가장 많이 주문된 주문 횟수 만큼의 주문된 세트 메뉴만 뽑기
        return getSetMenus(maxOrderCount, course);
    }

    private String getSortedOrder(String order) {
        char[] stringToChar = order.toCharArray();
        Arrays.sort(stringToChar);
        return new String(stringToChar);
    }

    private void countMenuCombination(String order, int[] course) {
        List<String> menuList = IntStream.range(0, order.length())
                .mapToObj(i -> String.valueOf(order.charAt(i)))
                .collect(Collectors.toList());

        getCombination(menuList, course);
    }

    private void getCombination(List<String> order, int[] course) {
        boolean[] visited = new boolean[order.size()];

        for (int num : course) {
            combination(order, visited, 0, num);
        }
    }

    private void combination(List<String> arr, boolean[] visited, int start, int r) {
        if(r == 0) {
            saveCombination(arr, visited);
            return;
        } else {
            for(int i = start; i < arr.size(); i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    private void saveCombination(List<String> arr, boolean[] visited) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < arr.size() ; i++) {
            if (visited[i]) {
                stringBuilder.append(arr.get(i));
            }
        }

        String set = stringBuilder.toString();

        menusCombination.put(set, menusCombination.getOrDefault(set, 0) + 1);
    }

    private List<Integer> getMaxOrderCount(int[] course) {
        List<Integer> maxOrderCount = new ArrayList<>();

        for (int courseSize : course) {
            maxOrderCount.add(getEachMaxOrderCount(courseSize));
        }

        return maxOrderCount;
    }

    private Integer getEachMaxOrderCount(int courseSize) {
        int max = Integer.MIN_VALUE;

        for (String combination : menusCombination.keySet()) {
            if (combination.length() == courseSize) {
                if (menusCombination.get(combination) > max && menusCombination.get(combination) > 1) {
                    max = menusCombination.get(combination);
                }
            }
        }

        return max;
    }


    private List<String> getSetMenus(List<Integer> maxOrderCount, int[] course) {
        List<String> setMenus = new ArrayList<>();

        for (int i = 0 ; i < course.length ; i++) {
            getEachSetMenus(maxOrderCount.get(i), course[i], setMenus);
        }

        Collections.sort(setMenus);

        return setMenus;
    }

    private void getEachSetMenus(int max, int courseSize, List<String> setMenus) {
        for (String menu : menusCombination.keySet()) {
            if (menu.length() == courseSize) {
                if (menusCombination.get(menu) == max) {
                    setMenus.add(menu);
                }
            }
        }
    }
}
