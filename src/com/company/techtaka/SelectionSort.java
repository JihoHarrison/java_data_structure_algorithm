package com.company.techtaka;

import java.util.Queue;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/04
 * Time: 12:51 오전
 */
public class SelectionSort {

    public static void selectionSort(int[] a) {
        int min;
        int size = a.length;
        int temp;


        for (int i = 0; i < size - 1; i++) {
            min = i;
            for (int j = i + 1; j < size; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
}