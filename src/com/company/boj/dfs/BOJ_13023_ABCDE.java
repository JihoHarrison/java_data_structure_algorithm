package com.company.boj.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/25
 * Time: 7:46 오후
 * desc: 탐색했을 때 깊이가 4인 경우가 있다면 A-B-C-D-E가 친구 즉, 이어져있다는 뜻이므로 count에 1넣어주면 된다.
 */
public class BOJ_13023_ABCDE {

    private static int N;
    private static int M;
    private static List<Integer>[] list;
    private static boolean[] visited;
    private static int count = 0;


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        list = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }

        System.out.println(count);
    }

    private static void dfs(int start, int cnt) {

        visited[start] = true;

        if (cnt == 4) {
            count = 1;
            return;
        }

        for (int i = 0; i < list[start].size(); i++) {
            if (!visited[list[start].get(i)]) {
                visited[list[start].get(i)] = true;
                dfs(list[start].get(i), cnt + 1);
                visited[list[start].get(i)] = false;
            }
        }
    }
}
