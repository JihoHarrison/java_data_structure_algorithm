package com.company.techtaka;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/28
 * Time: 12:11 오후
 * desc: LinkedList 구현
 */
public class LinkedListNode {

    int data;
    LinkedListNode next = null;

    public LinkedListNode(int data) {
        this.data = data;
    }

    /**
     * 요소 추가 메서드
     **/
    public void addNode(int data) {
        LinkedListNode node = new LinkedListNode(data);
        LinkedListNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    /**
     * 삭제 메서드
     **/
    public void deleteNode(int data) {
        LinkedListNode n = this;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }
}
