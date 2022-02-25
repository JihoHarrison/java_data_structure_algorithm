package com.company.boj.dfs;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/25
 * Time: 5:53 오후
 */
public class BOJ_2668_숫자고르기 {

    private static int N;
    private static int[] list;
    private static boolean[] visited;
    private static List<Integer> answerList;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        list = new int[N + 1];
        visited = new boolean[N + 1];
        answerList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list[i] = scan.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            int target = i;
            dfs(i, target);
            visited[i] = false;
        }

        System.out.println(answerList.size());
    }

    private static void dfs(int depth, int target) {

        if (list[depth] == target) {
            answerList.add(target);
        }

        if (!visited[list[depth]]) {
            visited[list[depth]] = true;
            dfs(list[depth], target);
            visited[list[depth]] = false;
        }
    }
}
