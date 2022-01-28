package com.company.techtaka;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/27
 * Time: 6:20 오후
 */
public class ex_01 {

    static int[] fiboArray;

    public static void main(String[] args) {

        System.out.println(fibo(6));
    }

    public static int fibo(int n) {
//        if(n == 0) return 1;
//        if(n == 1) return 1;
        if(n == 1) return 1;
        if(n == 2) return 1;


        return fibo(n - 1) + fibo(n - 2);
    }
}