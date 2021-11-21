package com.company.freespace;

import com.company.search.day03.IntQueue;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/19
 * Time: 9:57 오전
 * desc: Queue 구현하기!
 */
public class Queue01 {

    int front;
    int rear;
    int[] que;
    int max;
    int num;

    public Queue01(int capacity) {
        try {

            front = rear = 0;

            max = capacity;
            que = new int[max];

        } catch (Exception e) {
            max = 0;
        }
    }

//    public int deque() throws IntQueue.OverflowIntQueueException {
//        if(num >= 0) {
//            throw new IntQueue.OverflowIntQueueException();
//        }
//
//        que[front++];
//
//
//        return x;
//    }

}
