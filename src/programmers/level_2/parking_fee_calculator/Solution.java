package programmers.level_2.parking_fee_calculator;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
       List<Integer> result = solution.solution(new int[]{180, 5000, 10, 600}, new String[] {"05:34 5961 IN",
                "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        System.out.println(result);
    }
    public List<Integer> solution(int[] fees, String[] records) {
        Set<String> carLicensePlate = new HashSet<>();
        Map<String, String> parkingInfoStr = new HashMap<>();
        Map<String, Integer> parkingInfo = new HashMap<>();
        Map<String, Boolean> parkingInOrOut = new HashMap<>();

        // calculate total parking time
        for (String record : records) {
            String[] splitRecord = record.split(" ");
            if (splitRecord[2].equals("IN")) {
                parkingInfoStr.put(splitRecord[1], splitRecord[0]);
                parkingInOrOut.put(splitRecord[1], true);
                carLicensePlate.add(splitRecord[1]);
            } else {// "OUT" 맵에서 시간 꺼내서 계산 후 총 시간 저장할 맵에 넣기
                calculateParkingTime(parkingInfoStr, parkingInfo, splitRecord);
                parkingInOrOut.put(splitRecord[1], false);
            }
        }

        // out 하지 않은 차량도 찾아서 다시 시간 계산하기
        for (String car : parkingInOrOut.keySet()) {
            // 아직 주차장을 나가지 않았을 경우
            if (parkingInOrOut.get(car)) {
                calculateParkingFeeForNoOutCar(parkingInfoStr, parkingInfo, car);
            }
        }

        // calculate parking fee
        List<Integer> answer = calculateParkingFee(parkingInfo, carLicensePlate, fees);

        return answer;
    }
    // 13:00 2304 IN 17:00 2304 OUT
    private void calculateParkingTime(Map<String, String> tempInfo, Map<String, Integer> parkingInfo, String[] splitRecord) {
        // 13 00
        String[] inTime = tempInfo.get(splitRecord[1]).split(":");
        // 17 00
        String[] outTime = splitRecord[0].split(":");

        int inTimeHour = Integer.parseInt(inTime[0]);
        int inTimeMinute = Integer.parseInt(inTime[1]);

        int outTimeHour = Integer.parseInt(outTime[0]);
        int outTimeMinute = Integer.parseInt(outTime[1]);

        int totalTime = (outTimeHour * 60 + outTimeMinute) - (inTimeHour * 60 + inTimeMinute);

        int usingTime = 0;

        if (parkingInfo.containsKey(splitRecord[1])) {
            usingTime = parkingInfo.get(splitRecord[1]);
        }

        usingTime += totalTime;

        parkingInfo.put(splitRecord[1], usingTime);
    }

    private void calculateParkingFeeForNoOutCar(Map<String, String> tempInfo, Map<String, Integer> parkingInfo, String carNum) {
        // IN time
        String[] inTime = tempInfo.get(carNum).split(":");

        int inTimeHour = Integer.parseInt(inTime[0]);
        int inTimeMinute = Integer.parseInt(inTime[1]);

        int outTimeHour = 23;
        int outTimeMinute = 59;

        int totalTime = (outTimeHour * 60 + outTimeMinute) - (inTimeHour * 60 + inTimeMinute);

        int usingTime = 0;

        if (parkingInfo.containsKey(carNum)) {
            usingTime = parkingInfo.get(carNum);
        }

        usingTime += totalTime;

        parkingInfo.put(carNum, usingTime);
    }

    //180, 5000, 10, 160
    private List<Integer> calculateParkingFee(Map<String, Integer> parkingInfo, Set<String> carLicensePlate, int[] fees){
        // 차 번호판 오름차순으로 정렬
        List<String> sortedCarNum = new ArrayList<>(carLicensePlate);
        Collections.sort(sortedCarNum);

        List<Integer> answer = new ArrayList<>();

        int basicUsingTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        // 주차 요금 정산
        // 기본 시간 180분 이하면 기본 요금.
        // 초과하면 초과한 분 10분 당 160원 추가 (올림)
        // ex 5000 + ⌈(334 - 180) / 10⌉ x 600 = 14600

        for (String car : sortedCarNum) {
            int totalTime = parkingInfo.get(car);

            if (totalTime <= basicUsingTime) {
                answer.add(basicFee);
            } else {
                int parkingFee = basicFee + (int) Math.ceil((totalTime - basicUsingTime)/ (double) unitTime) * unitFee;
                answer.add(parkingFee);
            }
        }

        return answer;
    }
}
