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
    int num;
    int front;
    int rear;
    int[] que;
    int max;

    public Queue01(int capacity) {
        num = rear = front = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (Exception e) {
            max = 0;
        }
    }

    public int enque(int x) throws IntQueue.OverflowIntQueueException {
        if (num >= max) {
            throw new IntQueue.OverflowIntQueueException();
        }
        que[rear++] = x;
        num++;
        if (rear == max) {
            rear = 0;
        }
        return x;
    }

    public int deque() throws IntQueue.EmptyIntQueueException {
        if (num <= 0) {
            throw new IntQueue.EmptyIntQueueException();
        }
        int x = que[front++];
        num--;

        if (front == max) {
            front = 0;
        }

        return x;
    }
}
