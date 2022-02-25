package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/25
 * Time: 9:00 오후
 * desc: 완전 헛짚음. 다시 풀어야한다.
 */
public class Programmers_무지의먹방라이브 {


    public static void main(String[] args) {

        int[] food_times = {4,0,1};
        long k = 5;

        System.out.println(solution(food_times, k));

    }


    public static int solution(int[] food_times, long k) {
        int answer = 0;
        int idx = 0;
        int index = 0;
        int loopCount = 0;
        int zeroCount = 0;

        while (true) {

            loopCount++;
            index = idx % food_times.length;

            if (food_times[index] == 0) {
                idx++;
            }

            food_times[index]--;

            for (int i = 0; i < food_times.length; i++) {
                if (food_times[i] == 0) {
                    zeroCount++;
                    //System.out.println(zeroCount + "zero");
                }
            }
            //System.out.println(loopCount + " loop");
            if (loopCount == (int) k) {

                answer = index;
                break;
            }

            //if (zeroCount == food_times.length) break;

//            for (int i : food_times) {
//                System.out.print(i + " ");
//            }
//            System.out.println();


            idx++;
        }

        return answer;
    }
}