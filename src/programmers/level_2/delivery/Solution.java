package programmers.level_2.delivery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    // 선의 번호와 가중치를 한번에 저장하기 위해 Edge class를 만듦.
    static class Edge implements Comparable<Edge> {
        int number;
        int hour;

        public Edge(int number, int hour) {
            this.number = number;
            this.hour = hour;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.hour - edge.hour;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4);
        System.out.println(answer);
    }

    public int solution(int N, int[][] road, int K) {
        int answer;
        List<Edge>[] adjacentInfo = new ArrayList[N + 1];

        // 각 마을마다 ArrayList를 생성해준다. 몇개의 관계가 들어올 지 모르기 때문에 ArrayList를 이용한다.
        for (int i = 0; i <= N; i++) {
            adjacentInfo[i] = new ArrayList<>();
        }

        // 입력으로 들어오는 두 마을과 두 마을 사이 거리를 인접리스트에 저장한다.
        // 리스트는 각 마을의 인접한 엣지들을 저장한다. 양방향 그래프이기 때문에 두 마을 모두 저장해준다.
        for (int i = 0; i < road.length; i++) {
            adjacentInfo[road[i][0]].add(new Edge(road[i][1], road[i][2]));
            adjacentInfo[road[i][1]].add(new Edge(road[i][0], road[i][2]));
        }

        // 모든 마을의 정보를 저장한 후에 k시간 이하 걸리는 마을 개수를 받아서 리턴한다.
        answer = searchMinDeliveryHourCount(adjacentInfo, K, N);

        return answer;
    }

    private int searchMinDeliveryHourCount(List<Edge>[] adjacentInfo, int k, int N) {
        // 각 마을에 도달하는 최소 시간 저장할 배열 선언
        int[] hours = new int[N + 1];
        Arrays.fill(hours, Integer.MAX_VALUE);

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // 1번 마을을 엣지로 만들어서 큐에 푸쉬한다.
        queue.add(new Edge(1, 0));

        // 1번 마을에서 1번마을로 이동하는 시간은 0시간이므로 0시간으로 설정
        hours[1] = 0;

        // 큐가 빌때까지 반복한다.
        while (!queue.isEmpty()) {
            // 큐에 있는 간선을 하나 뽑아와서
            Edge edge = queue.poll();

            // 현재 보고 있는 간선이 잇고 있는 마을 번호와 가중치를 받아온다.
            int currentNumber = edge.number;
            int currentHour = edge.hour;

            // 기존 마을의 가중치보다 받아온 간선의 가중치가 더 크면 다음 단계로 패스
            if (hours[currentNumber] < currentHour) {
                continue;
            }

            // 받아온 간선과 연결되어 있는 인접한 간선들을 쭉 보면서 거쳐서 온 경로의 가중치가 더 작다면 갱신해준다.
            for (int i = 0; i < adjacentInfo[currentNumber].size(); i++) {
                // 현재 보고 있는 간선과 연결된 마을을 받아온다.
                int newNumber = adjacentInfo[currentNumber].get(i).number;
                // 현재 보고 있는 간선을 거쳐온 경로의 가중치를 새로 만들어준다.
                int newHour = adjacentInfo[currentNumber].get(i).hour + currentHour;

                // 새로 만든 가중치가 원래의 가중치보다 작으면 새롭게 만든 가중치로 바꿔준다.
                if (hours[newNumber] > newHour) {
                    hours[newNumber] = newHour;
                    queue.add(new Edge(newNumber, newHour));
                }
            }
        }

        int validDelivery = 0;

        // 모든 마을을 업데이트 시킨 뒤에 k시간 보다 배달시간이 적게 드는 마을이 있다면 개수 카운트하여 반환한다.
        for (int hour : hours) {
            if (hour <= k) {
                validDelivery++;
            }
        }

        return validDelivery;
    }
}
