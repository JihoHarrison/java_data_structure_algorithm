package com.company.boj.dfs;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/23
 * Time: 9:59 오후
 */
public class BOJ_14500_테트로미노 {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int ans = 0;

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
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
                check(i, j);
            }
        }

        System.out.println(ans);
    }

    private static void dfs(int x, int y, int sum, int depth) {

        if (depth >= 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + map[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    // ㅗ ㅓ ㅏ ㅜ 모양을 dfs로는 탐색 불가능하기 때문에 한 번의 탐색 완료 후 따로 진행해준다.
    private static void check(int row, int col) {

        // ㅗ
        if (row < n - 2 && col < m - 1)
            ans = Math.max(ans, map[row][col] + map[row + 1][col] + map[row + 2][col] + map[row + 1][col + 1]);

        // ㅜ
        if (row < n - 2 && col > 0)
            ans = Math.max(ans, map[row][col] + map[row + 1][col] + map[row + 2][col] + map[row + 1][col - 1]);

        // ㅏ
        if (row < n - 1 && col < m - 2)
            ans = Math.max(ans, map[row][col] + map[row][col + 1] + map[row][col + 2] + map[row + 1][col + 1]);

        // ㅓ
        if (row > 0 && col < m - 2)
            ans = Math.max(ans, map[row][col] + map[row][col + 1] + map[row][col + 2] + map[row - 1][col + 1]);

    }
}