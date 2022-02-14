package com.company.boj.dfs;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/14
 * Time: 3:59 오후
 */
public class BOJ_1012_유기농배추 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int countBug = 0;

    public static void main(String[] args) {

        int[][] list = {
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        boolean[][] visited = new boolean[list.length][list[0].length];

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                if (list[i][j] == 1 && !visited[i][j]) {
                    dfs(list, i, j, visited);
                    countBug++;
                }
            }
        }
        System.out.println(countBug);
    }

    public static void dfs(int[][] list, int x, int y, boolean[][] visited) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < list.length && ny < list[0].length) {
                if (list[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(list, nx, ny, visited);
                }
            }
        }
    }
}