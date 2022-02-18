package com.company.boj.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/18
 * Time: 4:08 오후
 * desc: 그냥 답을 보면서 적어봐도 이해가 안됐던 문제 중에 하나.. 이것도 대략적인 형식을 외워두면 좋을 듯.
 */
public class BOJ_1707_이분그래프 {

    static int V, K;
    static boolean check;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        K = scan.nextInt();

        for (int i = 0; i < K; i++) {
            check = false;
            V = scan.nextInt();

            int[] colors = new int[V + 1];
            List<Integer>[] adjacent = new ArrayList[V + 1];
            for (int j = 1; j <= V; j++) {
                adjacent[j] = new ArrayList();
            }

            int E = scan.nextInt();
            for (int k = 0; k < E; k++) {

                int first = scan.nextInt();
                int second = scan.nextInt();

                adjacent[first].add(second);
                adjacent[second].add(first);
            }

            for (int l = 1; l <= V; l++) {
                if (colors[l] == 0) {
                    dfs(l, 1, adjacent, colors);
                }
            }
            if (check) {
                System.out.println("NO");
            } else {
                System.out.println("Yes");
            }
        }
    }

    static void dfs(int i, int color, List<Integer>[] adjacent, int[] colors) {

        colors[i] = color;

        if (check) //만약 result가 이미 true라면 더 수행할 필요없이 종료
            return;

        for (Integer next : adjacent[i]) {
            if (colors[next] == colors[i]) {
                check = true;
                return;
            }
            if (colors[next] == 0) {
                dfs(next, color * -1, adjacent, colors);
            }
        }
    }
}