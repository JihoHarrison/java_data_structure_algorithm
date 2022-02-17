package com.company.boj.dfs;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/17
 * Time: 4:13 오후
 * desc: dp를 적용해야 시간 초과가 안나는 문제임.. DP는 나올 때 마다 보는걸로..
 */
public class BOJ_1520_내리막길 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static int M;
    public static int N;
    public static int count = 0;
    public static int[][] dp;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        int[][] map = new int[N][M];
        dp = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        dp[N - 1][M - 1] = 1;
        dfs(map, visited, 0, 0, map[0][0]);
        System.out.print(dp[0][0]);

    }

    public static void dfs(int[][] map, boolean[][] visited, int x, int y, int pos) {

        pos = map[x][y];

        if (x == N - 1 && y == M - 1) {
            return;
        }

        if (visited[x][y]) return;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                // 이 전 값이 더 큰 경우만 방문 할 수 있다는 조건을 잘 기억해야한다.
                if (pos > map[nx][ny]) {
                    if (dp[nx][ny] != 0) {
                        dp[x][y] += dp[nx][ny];
                    } else {
                        dfs(map, visited, nx, ny, pos);
                        dp[x][y] += dp[nx][ny];
                    }
                }
            }
        }
    }
}