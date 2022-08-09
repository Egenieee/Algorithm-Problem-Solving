package programmers.etc.mock_test_second.no_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(5, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1);
        for (int a : answer) {
            System.out.println(a);
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Edge>[] adjacentInfo = new ArrayList[n + 1];

        // 각 마을마다 ArrayList를 생성해준다. 몇개의 관계가 들어올 지 모르기 때문에 ArrayList를 이용한다.
        for (int i = 0; i <= n; i++) {
            adjacentInfo[i] = new ArrayList<>();
        }

        // 입력으로 들어오는 두 마을과 두 마을 사이 거리를 인접리스트에 저장한다.
        // 리스트는 각 마을의 인접한 엣지들을 저장한다. 양방향 그래프이기 때문에 두 마을 모두 저장해준다.
        for (int i = 0; i < roads.length; i++) {
            adjacentInfo[roads[i][0]].add(new Edge(roads[i][1], 1));
            adjacentInfo[roads[i][1]].add(new Edge(roads[i][0], 1));
        }

        int[] result = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            result[i] = searchMinimumComebackDistance(adjacentInfo, n, sources[i], destination);
        }

        return result;
    }

    private int searchMinimumComebackDistance(List<Edge>[] adjacentInfo, int n, int start, int destination) {
        // 시작 지역부터 각 지역에 도달하는 최소 시간 저장할 배열 선언
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // 1번 마을을 엣지로 만들어서 큐에 푸쉬한다.
        queue.add(new Edge(start, 0));

        // 시작점에서 시작점으로 이동하는 시간은 0이므로 초기화
        distance[start] = 0;

        // 큐가 빌때까지 반복한다.
        while (!queue.isEmpty()) {
            // 큐에 있는 간선을 하나 뽑아와서
            Edge edge = queue.poll();

            // 현재 보고 있는 간선이 잇고 있는 지역 번호와 가중치를 받아온다.
            int currentRegion = edge.number;
            int currentDistance = edge.distance;

            if (!visited[currentRegion]) {
                visited[currentRegion] = true;
                if (currentRegion == destination) {
                    break;
                }
                // 받아온 간선과 연결되어 있는 인접한 간선들을 쭉 보면서 거쳐서 온 경로의 가중치가 더 작다면 갱신해준다.
                for (int i = 0; i < adjacentInfo[currentRegion].size(); i++) {
                    // 현재 보고 있는 간선과 연결된 지역을 받아온다.
                    int newRegion = adjacentInfo[currentRegion].get(i).number;
                    // 현재 보고 있는 간선을 거쳐온 경로의 가중치를 새로 만들어준다.
                    int newDistance = adjacentInfo[currentRegion].get(i).distance + currentDistance;

                    // 새로 만든 가중치가 원래의 가중치보다 작으면 새롭게 만든 가중치로 바꿔준다.
                    if (distance[newRegion] > newDistance) {
                        distance[newRegion] = newDistance;
                        queue.add(new Edge(newRegion, newDistance));
                    }
                }
            }
        }

        if (distance[destination] == Integer.MAX_VALUE) {
            return -1;
        }

        return distance[destination];
    }

    static class Edge implements Comparable<Edge> {
        int number;
        int distance;

        public Edge(int number, int hour) {
            this.number = number;
            this.distance = hour;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.distance - edge.distance;
        }
    }
}
