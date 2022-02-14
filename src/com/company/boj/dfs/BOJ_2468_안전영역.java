package com.company.boj.dfs;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/14
 * Time: 10:22 오후
 */
public class BOJ_2468_안전영역 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public static int count = 0;
    public static int N;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();

        int[][] land1 = {
                {6, 8, 2, 6, 2},
                {3, 2, 3, 4, 6},
                {6, 7, 3, 3, 2},
                {7, 2, 5, 3, 6},
                {8, 9, 5, 2, 7}
        };

        int[][] land2 = {
                {9, 9, 9, 9, 9, 9, 9},
                {9, 2, 1, 2, 1, 2, 9},
                {9, 1, 8, 7, 8, 1, 9},
                {9, 2, 7, 9, 7, 2, 9},
                {9, 1, 8, 7, 8, 1, 9},
                {9, 2, 1, 2, 1, 2, 9},
                {9, 9, 9, 9, 9, 9, 9}
        };

        int x = land2.length;
        int y = land2[0].length;
        boolean[][] visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (land2[i][j] > N && !visited[i][j]) {
                    dfs(land2, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println(count);


    }


    public static void dfs(int[][] land, int x, int y, boolean[][] visited) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < land.length && ny < land[0].length) {
                if (land[nx][ny] > N && !visited[nx][ny]) {
                    dfs(land, nx, ny, visited);
                }
            }
        }

    }

}
