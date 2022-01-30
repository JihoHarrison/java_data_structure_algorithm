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

//    public void addNode(int data) {
//        LinkedListNode end = new LinkedListNode(data);
//        LinkedListNode n = this;
//        System.out.println();
//        while (n.next != null) {
//            n = n.next;
//        }
//        n.next = end;
//    }

    public void append(int data) {
        LinkedListNode end = new LinkedListNode(data);
        LinkedListNode n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }






}
