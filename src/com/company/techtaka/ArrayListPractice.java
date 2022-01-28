package com.company.techtaka;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/28
 * Time: 1:29 오후
 */

class ArrayListSample {
    private Object[] data;
    private int index;
    private int size;

    public ArrayListSample() {
        this.size = 1;
        this.index = 0;
        this.data = new Object[this.size];
    }

    public void add(Object obj){
        if(this.index == this.size) {
            doubling();
        }
        data[index] = obj;
        this.index++;
    }

    public void doubling() {
        this.size = this.size * 2;
        Object[] newLists = new Object[this.size];
        for(int i = 0; i < this.size - 1; i++) {
            newLists[i] = data[i];
        }
        this.data = newLists;
    }




}

public class ArrayListPractice {


    public static void main(String[] args) {

    }





}
