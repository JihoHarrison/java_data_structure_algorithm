package com.company.programmers.kakao;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/23
 * Time: 7:18 오후
 */
public class Programmers_주차요금계산 {


    public static void main(String[] args) {

        String[] str = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] fees = {180, 5000, 10, 600};
        int[] sol = solution(fees, str);
        for (int i : sol) {
            System.out.print(i + " ");
        }

    }


    public static int[] solution(int[] fees, String[] records) {

        HashMap<String, Integer> parked = new HashMap<>();
        HashMap<String, Integer> carTimes = new HashMap<>();
        List<String> cars = new ArrayList<>();

        for (String record : records) {

            String[] rc = record.split(" ");

            String[] splitTime = rc[0].split(":");

            int time = Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
            String carNum = rc[1];

            if (!cars.contains(carNum)) {
                cars.add(carNum);
                carTimes.put(carNum, 0);
            }

            if (parked.containsKey(carNum)) {
                carTimes.put(carNum, carTimes.get(carNum) + (time - parked.get(carNum)));
                parked.remove(carNum);
            } else {
                parked.put(carNum, time);
            }
        }

        int[] answer = new int[cars.size()];
        Collections.sort(cars);

        for (int i = 0; i < cars.size(); i++) {

            /** 기본 요금 **/
            answer[i] = fees[1];

            /** 남아있는 차 목록 가져오기 **/
            String car = cars.get(i);

            int time = carTimes.get(car) - fees[0];

            String[] lasts = "23:59".split(":");
            int lastTime = Integer.parseInt(lasts[0]) * 60 + Integer.parseInt(lasts[1]);

            /** 주차 되어있는 차가 남아있을 경우 위에서 구한 마지막 시간으로 계산 적용**/
            if (parked.containsKey(car)) {
                time += lastTime - parked.get(car);
            }

            if (time > 0) {
                /** 반올림 메서드 ceil의 인자가 double이라서 형변환 필요. 안하면 값 다르게 나옴. **/
                answer[i] += (Math.ceil(time / (double) fees[2]) * fees[3]);
            }
        }

        return answer;
    }
}