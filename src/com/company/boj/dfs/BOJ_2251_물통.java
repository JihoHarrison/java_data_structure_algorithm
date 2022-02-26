package com.company.boj.dfs;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/26
 * Time: 4:02 오후
 * desc: 하나의 물병의 물 양으로 다른 병들을 채워가는 모든 경우의 수를 구하는 로직이 어려웠음.. 나중에 다시 풀어봐도 도움 많이 될 듯 하다.
 */
public class BOJ_2251_물통 {

    private static int[] limit;
    private static boolean[][] visited;
    private static Set<Integer> answer;
    private static int A, B, C;

    public static void main(String[] args) {

        answer = new TreeSet<Integer>();
        limit = new int[3];
        visited = new boolean[201][201];

        Scanner scan = new Scanner(System.in);
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextInt();

        limit[0] = A;
        limit[1] = B;
        limit[2] = C;

        dfs(0, 0, limit[2]);

        System.out.println(answer);

    }

    private static void dfs(int a, int b, int c) {

        if (visited[a][b]) return;

        // 물통 a가 비어있으면서 c가 가질 수 있는 모든 물의 양의 경우의 수 이므로 다음과 같은 조건이 들어간다.
        if (a == 0) {
            answer.add(c);
        }

        visited[a][b] = true;

        // a -> b
        if (a + b > limit[1]) {
            dfs((a + b) - limit[1], limit[1], c);
        } else {
            dfs(0, a + b, c);
        }

        // b -> a
        if (a + b > limit[0]) {
            dfs(limit[0], (a + b) - limit[0], c);
        } else {
            dfs(a + b, 0, c);
        }

        // c -> a
        if (a + c > limit[0]) {
            dfs(limit[0], b, (a + c) - limit[0]);
        } else {
            dfs(a + c, b, 0);
        }

        // c -> b
        if (b + c > limit[1]) {
            dfs(a, limit[1], (b + c) - limit[1]);
        } else {
            dfs(a, b + c, 0);
        }

        // 물통 C만 가득 차 있기 때문에 a와 b에 들어있는 물 양의 합은 항상 c와 같다.
        // 따라서 위 조건들 처럼 범위 검사 진행 할 필요가 없음.
        // b -> c
        // a -> c
        dfs(a, 0, b + c);
        dfs(0, b, a + c);
    }
}
