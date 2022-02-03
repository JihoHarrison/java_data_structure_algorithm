package com.company.leetcode;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/03
 * Time: 12:51 오후
 */
public class LeetCode_NumberOfIslands {

    private static int[] dx = {0, -1, 0, 1};    // dx, dy = 상하좌우
    private static int[] dy = {-1, 0, 1, 0};
    private static boolean[][] visited;
    private static int N = 0;

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid));


    }

    public static int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    N++;
                }
            }
        }
        return N;
    }

    public static void dfs(int x, int y, char[][] grid) {

        grid[x][y] = '0';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny < grid[0].length && nx < grid.length && ny >= 0 && grid[nx][ny] == '1') {
                dfs(nx, ny, grid);
            }
        }


    }
}