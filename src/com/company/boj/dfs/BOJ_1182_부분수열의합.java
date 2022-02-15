package com.company.boj.dfs;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/15
 * Time: 12:33 오후
 */
public class BOJ_1182_부분수열의합 {

    public static int N;
    public static int count = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        int target = scan.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }

        dfs(arr, 0, 0, target);

        // 공집합. 아무것도 더하지 않았을 경우를 제외
        if (target == 0) {
            count = count - 1;
        }

        System.out.println(count);
    }

    public static void dfs(int[] arr, int sum, int depth, int target) {
        if (depth == arr.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        // 형식 자체를 외워야 할 듯. 부분수열 구하는 재귀 형식.
        dfs(arr, sum + arr[depth], depth + 1, target); // 원소의 값을 더하는 결과값의 모든 경우의 수
        System.out.println(arr[depth] + "up");
        dfs(arr, sum, depth + 1, target); // 현재 arr[depth] 값을 포함하지 않는 경우
        //System.out.println(sum + "down");
    }
}