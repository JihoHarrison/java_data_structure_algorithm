package com.company.techtaka;

public class QuickSort {


    public static void main(String[] args) {


        int[] array = {4, 3, 6, 2, 67, 2, 13, 5, 5, 2};

        printArray(array);
        quickSort(array);
        printArray(array);

    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static int partition(int[] a, int start, int end) {

        int pivot = a[(start + end) / 2];

        while (start <= end) {
            while (a[start] < pivot) start++;
            while (a[end] > pivot) end--;

            if (start <= end) {
                swap(a, start, end);
                start++;
                end--;
            }
        }

        return start;
    }

    public static void swap(int[] a, int start, int end) {
        int temp;
        temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }


    public static void quickSort(int[] a, int start, int end) {

        int part2 = partition(a, start, end);

        if (start < part2 - 1) {
            quickSort(a, start, part2 - 1);
        }
        if (start < end) {
            quickSort(a, part2, end);
        }
    }

    public static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}