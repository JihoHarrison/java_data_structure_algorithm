package com.company.techtaka;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/27
 * Time: 6:20 오후
 */
public class ex_01 {

    static int[] fiboArray;

    public static void main(String[] args) {

//        for (int i = 1; i <= 6; i++) {
//            System.out.println(fibo(i));
//        }

        gcd(5, 8);


    }

    public static int fibo(int n) {
//        if(n == 0) return 1;
//        if(n == 1) return 1;
        if (n == 1) return 1;
        if (n == 2) return 1;


        return fibo(n - 1) + fibo(n - 2);
    }

    public static int gcd(int num1, int num2) {
        ArrayList<Integer> arrayListNum1 = new ArrayList<>();
        ArrayList<Integer> arrayListNum2 = new ArrayList<>();
        int max = 0;

        for (int i = 1; i <= num1; i++) {
            if (num1 % i == 0) {
                arrayListNum1.add(i);
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 1; i <= num2; i++) {
            if (num2 % i == 0) {
                arrayListNum2.add(i);
                System.out.print(i + " ");
            }
        }
        for (int i = 0; i < arrayListNum1.size(); i++) {
            for (int j = 0; j < arrayListNum2.size(); j++) {
                if (Objects.equals(arrayListNum1.get(i), arrayListNum2.get(j))) {
                    if (max < arrayListNum1.get(i)) {
                        max = arrayListNum1.get(i);
                    }
                }
            }
        }
        return max;
    }
}