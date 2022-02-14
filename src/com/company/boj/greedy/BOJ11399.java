package com.company.boj.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/22
 * Time: 9:58 오후
 */
public class BOJ11399 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int result = 0;

        int N = scan.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            result += sum;
        }
        System.out.println(result);


    }
}

//public class BOK11399 {
//    public static boolean[] isVisited;
//    public static int k = 0;
//    public static int[] index = new int[]{};
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        int N = scan.nextInt();
//        int[] arr = new int[N];
//        isVisited = new boolean[N];
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = i + 1;
//        }
//        dfs(0, arr);
//
//        System.out.print(index[0]);
//
//    }
//
//    public static void dfs(int depth, int[] arr) {
//        if (depth == arr.length) {
//            int sum = 0;
//            for (int i = 1; i < arr.length; i++) {
//
//                sum += arr[i - 1];
//
//            }
//            index[k++] = sum;
//            return;
//        }
//
//        for (int i = depth; i < arr.length; i++) {
//            if (!isVisited[i]) {
//                isVisited[i] = true;
//                dfs(depth + 1, arr);
//                isVisited[i] = false;
//            }
//        }
//    }
//}
//