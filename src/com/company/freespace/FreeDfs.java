package com.company.freespace;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/19
 * Time: 1:23 오후
 */
public class FreeDfs {

    private static int N;
    private static int M;
    private static int[] result = new int[10];
    private static boolean[] isVisited = new boolean[6];

    public static void main(String[] args) {
        int[] dice = {1, 2, 3, 4, 5, 6};
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        dfs(0, dice);
    }

    public static void dfs(int depth, int[] dice) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < dice.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = dice[i];
                dfs(depth + 1, dice);
                isVisited[i] = false;
            }
        }
    }
}
