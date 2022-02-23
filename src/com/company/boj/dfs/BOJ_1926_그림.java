package com.company.boj.dfs;

import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/23
 * Time: 8:59 오후
 */
public class BOJ_1926_그림 {

    private static int n;
    private static int m;
    private static int max = 0;
    private static int pictureCount = 0;

    private static int[][] map;
    private static boolean[][] visited;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, 0);
                    pictureCount++;
                }

            }
        }

        System.out.println(pictureCount);
        System.out.print(max);
    }

    private static void dfs(int x, int y, int cnt) {

        visited[x][y] = true;
        cnt++;
        max = Math.max(max, cnt);

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny, cnt);
                }
            }
        }
    }
}