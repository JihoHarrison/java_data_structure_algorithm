package com.company.bok.dfs;

import java.util.*;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/13
 * Time: 1:48 오전
 */
public class BOK15655 {

    private static int size;
    private static int[] arr;
    private static boolean[] isVisited;
    private static int[] result;
    private static int n, m;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        isVisited = new boolean[n];
        arr = new int[n];
        size = arr.length;
        result = new int[m];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        dfs(0);


    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int j = 0; j < n; j++) {

            if (!isVisited[j]) {
                isVisited[j] = true;
                System.out.println(depth + " depth");
                result[depth] = arr[j];
                dfs(depth + 1);
                //System.out.println(depth + " 22");
                isVisited[j] = false;
            }
        }
    }
}
