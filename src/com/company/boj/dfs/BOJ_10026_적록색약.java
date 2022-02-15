package com.company.boj.dfs;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/15
 * Time: 11:43 오전
 */
public class BOJ_10026_적록색약 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int normalCount = 0;
    static int strangeCount = 0;

    public static void main(String[] args) {

        char[][] list = {
                {'R', 'R', 'R', 'B', 'B'},
                {'G', 'G', 'B', 'B', 'B'},
                {'B', 'B', 'B', 'R', 'R'},
                {'B', 'B', 'R', 'R', 'R'},
                {'R', 'R', 'R', 'R', 'R'}
        };
        char[][] rgbArrStrange = new char[list.length][list[0].length];

        boolean[][] visitedForNormal = new boolean[list.length][list[0].length];
        boolean[][] visitedForRedGreen = new boolean[list.length][list[0].length];


        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                rgbArrStrange[i][j] = list[i][j];
                if (rgbArrStrange[i][j] == 'G') rgbArrStrange[i][j] = 'R';
                System.out.print(rgbArrStrange[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                if (!visitedForNormal[i][j]) {
                    dfs(list, i, j, visitedForNormal, list[i][j]);
                    normalCount++;
                }
            }
        }

        for (int i = 0; i < rgbArrStrange.length; i++) {
            for (int j = 0; j < rgbArrStrange[0].length; j++) {
                if (!visitedForRedGreen[i][j]) {
                    dfs(rgbArrStrange, i, j, visitedForRedGreen, rgbArrStrange[i][j]);
                    strangeCount++;
                }
            }
        }

        System.out.println(normalCount + " " + strangeCount);

    }

    public static void dfs(char[][] list, int x, int y, boolean[][] visited, char ch) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < list.length && ny < list[0].length) {
                if (!visited[nx][ny] && list[nx][ny] == ch) {
                    dfs(list, nx, ny, visited, ch);
                }
            }
        }
    }
}
