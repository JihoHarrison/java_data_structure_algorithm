package com.company.boj.dfs;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/19
 * Time: 11:10 오후
 * desc: while문 다룰 때 루프 내부에서 static 변수 다루는 법에 대해 주의 및 학습 필요함.
 */
public class BOJ_2573_빙산 {

    private static int N;
    private static int M;
    private static int year = 0;

    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        int[][] map = new int[N][M];
        int[][] melt = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        while (true) {
            // static 변수로 count 만들면 제대로 동작 안함.
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j, map, melt, visited);
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.print(count);
                break;
            } else if (count > 1) {
                System.out.print(year);
                break;
            }

            melting(map, melt, visited);
            year++;
        }
    }

    private static void dfs(int x, int y, int[][] map, int[][] melt, boolean[][] visited) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                if (map[nx][ny] != 0 && !visited[nx][ny]) {
                    dfs(nx, ny, map, melt, visited);
                }
                if (map[nx][ny] == 0) {
                    melt[x][y]++;
                }
            }
        }
    }

    private static void melting(int[][] map, int[][] melt, boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] -= melt[i][j];

                if (map[i][j] < 0) {
                    map[i][j] = 0;
                }

                // metling 함수가 호출되었다는 것은 한 번 더 dfs를 불러줘야 한다는 의미이기 때문에 visited 배열과 melt 배열의 위치를 계산 후 다시 돌려놓아준다.
                melt[i][j] = 0;
                visited[i][j] = false;
            }
        }
    }
}