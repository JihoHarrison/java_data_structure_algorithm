package com.company.techtaka;

import java.util.Stack;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/04
 * Time: 2:28 오전
 */
public class StackDfs {


    public static void main(String[] args) {

        int[] a = {9, 1, 4, 2, 3, 7, 5, 8, 4};
        quickSort(a, 0, a.length - 1);

        for (int i : a) {
            System.out.print(i + " ");
        }

    }

    public static void quickSort(int[] a, int start, int end) {
        int part = partition(a, start, end);

        if (start < part - 1) {
            quickSort(a, start, part - 1);
        }
        if (part < end) {
            quickSort(a, part, end);
        }
    }

    public static int partition(int[] a, int start, int end) {
        int mid = a[(start + end) / 2];

        while (start <= end) {
            while (a[start] < mid) start++;
            while (a[end] > mid) end--;
            if (start <= end) {
                swap(a, start, end);
                start++;
                end--;
            }
        }

        return start;
    }

    public static void swap(int[] a, int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
}