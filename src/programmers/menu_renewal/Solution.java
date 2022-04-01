package programmers.menu_renewal;

import java.util.*;

//["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
//["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
//["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> answer = solution.solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5});
        for (String menu : answer) {
            System.out.println(menu);
        }
    }
    public List<String> solution(String[] orders, int[] course) {
        List<Integer> courseNumber = toIntegerList(course);

        // 2번 이상 시킨 세트 메뉴들 Set에 저장
        Set<String> setMenu = new HashSet<>();

        for (int i = 0 ; i < orders.length ; i++) {
            List<String> standardOrder = toList(orders[i]);

            for (int j = i + 1 ; j < orders.length ; j++) {
                List<String> counterpartOrder = toList(orders[j]);

                standardOrder.retainAll(counterpartOrder);

                if (courseNumber.contains(standardOrder.size())) {
                    String menu = getSetMenu(standardOrder);
                    setMenu.add(menu);
                }

                standardOrder = toList(orders[i]);
            }
        }

        // 각 세트 메뉴당 얼마나 시켰는 지 Map에 저장
        Map<String, Integer> orderCountPerSetMenu = getOrderCountPerSetMenu(orders, setMenu);


        // 가장 많이 시킨 메뉴만 뽑기

        return getFinalSetMenu(courseNumber, orderCountPerSetMenu);
    }

    private Map<String, Integer> getOrderCountPerSetMenu(String[] orders, Set<String> setMenu) {
        Map<String, Integer> orderCountPerSetMenu = new HashMap<>();

        for (String menu : setMenu) {
            for (String order : orders) {
                List<String> menuList = toList(menu); // AB
                List<String> orderList = toList(order); //ABCDE
                menuList.retainAll(orderList);
                if (menuList.size() == menu.length()) {
                    orderCountPerSetMenu.put(menu, orderCountPerSetMenu.getOrDefault(menu, 0) + 1);
                }
            }
        }

        return orderCountPerSetMenu;
    }


    private List<String> getFinalSetMenu(List<Integer> courseNumber, Map<String, Integer> orderCountSetMenu) {
        Map<Integer, Integer> maxOrderCountPerMenuLength = getMaxOrderCountPerMenuLength(courseNumber, orderCountSetMenu);
        List<String> finalSetMenu = new ArrayList<>();

        // 가장 많이 시킨 메뉴만 뽑기
        int maxCountPerMenu;

        for (String menu : orderCountSetMenu.keySet()) {
            maxCountPerMenu = maxOrderCountPerMenuLength.get(menu.length());

            if (orderCountSetMenu.get(menu) == maxCountPerMenu) {
                finalSetMenu.add(menu);
            }
        }

        // 정렬
        Collections.sort(finalSetMenu);

        return finalSetMenu;
    }

    private Map<Integer, Integer> getMaxOrderCountPerMenuLength(List<Integer> courseNumber, Map<String, Integer> orderCountSetMenu) {
        Map<Integer, Integer> maxOrderCountPerMenuLength = initMap(courseNumber);
        int maxOrderCount = 0;
        int preMenuLength = 0;

        for (String menu : orderCountSetMenu.keySet()) {
            if (preMenuLength != menu.length()) {
                maxOrderCount = Integer.MIN_VALUE;
            }
            preMenuLength = menu.length();
            if (maxOrderCountPerMenuLength.get(menu.length()) > maxOrderCount){
                maxOrderCountPerMenuLength.put(preMenuLength, orderCountSetMenu.get(menu));
            }
        }

        return maxOrderCountPerMenuLength;
    }

    private Map<Integer, Integer> initMap(List<Integer> courseNumber) {
        Map<Integer, Integer> maxOrderCountPerMenuLength = new HashMap<>();

        for (int course : courseNumber) {
            maxOrderCountPerMenuLength.put(course, 0);
        }

        return maxOrderCountPerMenuLength;
    }

    private List<Integer> toIntegerList(int[] courses) {
        List<Integer> integerList = new ArrayList<>();

        for (int course : courses) {
            integerList.add(course);
        }

        return integerList;
    }
    private List<String> toList(String order) {

        String[] menuStrings = order.split("");

        return new ArrayList<>(Arrays.asList(menuStrings));
    }
    private String getSetMenu(List<String> standardOrder) {
        Collections.sort(standardOrder);
        StringBuilder setMenu = new StringBuilder();

        for (String menu : standardOrder) {
            setMenu.append(menu);
        }

        return setMenu.toString();
    }
}
