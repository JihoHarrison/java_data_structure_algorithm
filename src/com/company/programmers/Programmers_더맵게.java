package com.company.programmers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/01
 * Time: 8:58 오후
 */
public class Programmers_더맵게 {

    public static Queue<Integer> heap = new PriorityQueue<>();

    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 9, 10, 12};

        System.out.println(solution(scoville, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;


        for (int i = 0; i < scoville.length; i++) {
            heap.offer(scoville[i]);
        }

        return answer = calcScoville(heap, K);
    }

    public static int calcScoville(Queue<Integer> heap, int K) {
        int count = 0;
        int scoville = 0;
        while (heap.peek() <= K) {
            if(heap.size() <= 1) return -1;
            int first = heap.poll();
            int second = heap.poll();
            scoville = first+ (second * 2);
            count++;
            heap.offer(scoville);
        }
        return count;
    }
// isEmpty로만 생각하다가 While문의 조건 변경
//    public static int calcScoville(Queue<Integer> heap, int K) {
//        int scoville = 0;
//        int count = 0;
//        while (!heap.isEmpty()) {
//            scoville = heap.poll() + (heap.poll() * 2);
//            count++;
//            if (scoville > K) {
//                return count;
//            }
//        }
//        return -1;
//    }

}
