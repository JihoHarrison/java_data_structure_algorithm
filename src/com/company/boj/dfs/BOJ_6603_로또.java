package com.company.boj.dfs;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/21
 * Time: 3:54 오후
 */
public class BOJ_6603_로또 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] lotto;
        boolean[] visited;
        while (true) {
            int k = scan.nextInt();

            if (k == 0) {
                break;
            }
            lotto = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                lotto[i] = scan.nextInt();
            }
            System.out.println();
            dfs(0, 0, lotto, visited);
        }
    }

    public static void dfs(int start, int depth, int[] lotto, boolean[] visited) {

        if (depth == 6) {
            for (int i = 0; i < lotto.length; i++) {
                if (visited[i]) System.out.print(lotto[i] + " ");
            }
            System.out.println();
        }

        for (int i = start; i < lotto.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1, lotto, visited);
                visited[i] = false;
            }
        }
    }
}