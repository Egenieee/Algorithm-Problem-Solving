package programmers.level_2.trucks_crossing_the_bridge;

import java.util.*;

public class Solution {
    static class Truck {
        int moveDistance;
        int weight;

        public Truck(int weight) {
            this.moveDistance = 0;
            this.weight = weight;
        }

        public int getMoveDistance() {
            return moveDistance;
        }

        public int getWeight() {
            return weight;
        }

        public void move() {
            moveDistance++;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        System.out.println(answer);
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int countOfTrucks = truck_weights.length;
        int seconds = 0;

        // 다리를 지날 트럭
        Queue<Truck> trucksToCross = getTrucks(truck_weights);

        // 다리를 지나고 있는 트럭
        Queue<Truck> crossingTrucks = new LinkedList<>();

        // 다리를 모두 건넌 트럭
        List<Truck> crossedTrucks = new ArrayList<>();

        while (true) {
            // 총 초수 증가
            seconds++;

            // 다리를 모두 이동한 트럭이 있다면 다리 밖으로 빼기
            if (!crossingTrucks.isEmpty() && crossingTrucks.peek().getMoveDistance() >= bridge_length) {
                crossedTrucks.add(crossingTrucks.poll());
            }

            if (countOfTrucks == crossedTrucks.size()) {
                break;
            }

            // 다리 위 트럭이 없다면 대기 트럭에서 한 대 가져와 다리 위로 올리자.
            if (crossingTrucks.isEmpty()) {
                crossingTrucks.add(trucksToCross.poll());
            } //다리 위에 있는 트럭에 대기 열의 트럭을 하나 더 올린 무게를 다리가 감당할 수 있다면, 하나 더 가져오자.
            else if (canGetOneMoreTruck(crossingTrucks, trucksToCross, weight)) {
                crossingTrucks.add(trucksToCross.poll());
            }

            // 다리 위에 있는 트럭 이동
            moveTrucks(crossingTrucks);
        }

        return seconds;
    }

    private Queue<Truck> getTrucks(int[] truck_weights) {
        Queue<Truck> trucks = new LinkedList<>();

        for (int weight : truck_weights) {
            trucks.add(new Truck(weight));
        }

        return trucks;
    }

    private boolean canGetOneMoreTruck(Queue<Truck> crossingTrucks, Queue<Truck> trucksToCross, int weight) {
        return (!trucksToCross.isEmpty()) &&
                (sumOfTrucksWeight(crossingTrucks) + trucksToCross.peek().getWeight() <= weight);
    }

    private int sumOfTrucksWeight(Queue<Truck> crossingTrucks) {
        return crossingTrucks.stream().mapToInt(Truck::getWeight).sum();
    }

    private void moveTrucks(Queue<Truck> crossingTrucks) {
        crossingTrucks.forEach(Truck::move);
    }
}
