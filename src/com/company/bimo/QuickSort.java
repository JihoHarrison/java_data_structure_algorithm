package com.company.bimo;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/08
 * Time: 3:07 오후
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] a = {9, 1, 4, 2, 3, 7, 5, 8, 4};
        quickSort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
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
                end--;
                start++;
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
