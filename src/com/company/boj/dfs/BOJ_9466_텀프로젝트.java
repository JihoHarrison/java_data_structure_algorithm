package com.company.boj.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/21
 * Time: 5:28 오후
 * desc: 못 풀었음.. 다시 풀어야 한다.
 */
public class BOJ_9466_텀프로젝트 {

    private static int T;
    private static int n;
    private static int[] students;
    private static boolean[] isVisited;
    private static boolean[] isDone;
    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();

        for (int j = 0; j < T; j++) {
            n = scanner.nextInt();
            numbers.clear();

            students = new int[n + 1];
            isVisited = new boolean[n + 1];
            isDone = new boolean[n + 1];
            count = 0;

            for (int i = 1; i <= n; i++) {
                students[i] = scanner.nextInt();
            }


            for (int i = 1; i <= n; i++) {
                if (!isDone[i]) {
                    dfs(i);
                }
            }

            stringBuilder.append(n - count);
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString().trim());
    }

    private static void dfs(int now) {
        if (isVisited[now]) {
            isDone[now] = true;
            count++;
        } else {
            isVisited[now] = true;
        }

        int next = students[now];

        if (!isDone[next]) {
            dfs(next);
        }

        isVisited[now] = false;
        isDone[now] = true;
    }


}
