package com.company.programmers;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/17
 * Time: 9:35 오후
 * desc: 내 방법대로 예제 테케는 통과하는데 제출시 난리남.. 풀이를 봤는데 세상... 머리 좋은 사람들이 너무 많다..
 */
public class Programmers_HIndex {

    public static void main(String[] args) {

        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;

        quickSort(citations);

        for (int i = 0; i < citations.length; i++) {

            int h = citations.length - i;

            if(citations[i] >= h) {
                answer = h;
                break;
            }
//            int book = citations[i];
//            int bookCount = 0;
//            for (int j = 0; j < citations.length; j++) {
//
//                if (book <= citations[j]) {
//                    bookCount++;
//                }
//            }
//
//            if (bookCount == book) {
//                answer = bookCount;
//                break;
//            }
        }

        return answer;
    }

    // 여기 아래는 문제 만만하게 보고 퀵정렬 직접 구현 해 본거..
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end) {

        int part = partition(array, start, end);

        if (start < part - 1) quickSort(array, start, part - 1);
        if (part < end) quickSort(array, part, end);
    }

    public static int partition(int[] array, int start, int end) {
        int mid = array[(start + end) / 2];
        while (start <= end) {
            while (array[start] < mid) start++;
            while (array[end] > mid) end--;
            if (start <= end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }

        return start;
    }

    public static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}