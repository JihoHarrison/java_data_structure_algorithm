package com.company.boj.dfs;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/24
 * Time: 7:26 오후
 * desc: 2차원 배열을 1차원 배열로 생각해야하는 문제.. 난 이렇게까지 머리 못굴릴거같다...ㅋㅋㅋㅋㅋ
 */
public class BOJ_9663_NQueen {

    private static int n;
    private static int[] queen;
    private static int count = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        queen = new int[n];

        dfs(0);
        System.out.println(count);

    }

    public static void dfs(int row) {

        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            queen[row] = i;

            if (check(row)) {
                dfs(row + 1);
            }
        }
    }

    public static boolean check(int col) {

        for (int i = 0; i < col; i++) {
            if (queen[col] == queen[i]) {
                return false;
            }

            if (Math.abs(col - i) == Math.abs(queen[i] - queen[col])) {
                return false;
            }
        }

        return true;
    }
}