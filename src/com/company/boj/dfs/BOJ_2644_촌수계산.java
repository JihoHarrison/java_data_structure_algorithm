package com.company.boj.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/18
 * Time: 2:44 오후
 * desc: 인접리스트를 n + 1개 만큼 할당해서 꼭 초기화 해 주는 것 까지 주의!
 */
public class BOJ_2644_촌수계산 {

    private static int answer = -1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int first = scan.nextInt();
        int second = scan.nextInt();

        int m = scan.nextInt();

        List<Integer>[] list = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            list[x].add(y);
            list[y].add(x);
        }

        dfs(list, first, second, 0, visited);

        System.out.print(answer);
    }

    private static void dfs(List<Integer>[] list, int x, int y, int cnt, boolean[] visited) {

        if (x == y) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < list[x].size(); i++) {
            if (!visited[list[x].get(i)]) {
                visited[list[x].get(i)] = true;
                dfs(list, list[x].get(i), y, cnt + 1, visited);
            }
        }
    }
}