package com.company.bimo;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/08
 * Time: 1:37 오후
 */
public class MergeSort {

    public static void main(String[] args) {

    }

    public static void mergeSort(int[] a, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, tmp, start, mid);
            mergeSort(a, tmp, mid + 1, end);
            merge(a, tmp, start, mid, end);
        }
    }

    public static void merge(int[] a, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = a[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                a[index] = tmp[part1];
                part1++;
            } else {
                a[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for (int j = 0; j <= mid - part1; j++) {
            a[index + j] = tmp[part1 + j];
        }
    }

}
