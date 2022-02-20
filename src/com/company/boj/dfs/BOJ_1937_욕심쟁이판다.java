package com.company.boj.dfs;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/21
 * Time: 1:56 오전
 * desc: DP는 아직 적용 못했음. 그놈의 visited 너무 막 사용하지 말자.
 */
public class BOJ_1937_욕심쟁이판다 {

    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};

    private static int N;

    private static int move = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(map, i, j, 0);
            }
        }

        System.out.println(move);
    }

    // TODO DP 적용시켜야 함.
    private static void dfs(int[][] map, int x, int y, int count) {

        // 첫 대나무 숲에서 최소 1년은 살 수 있으므로 방문 시 바로 count 값 증가
        count++;
        move = Math.max(move, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                if (map[nx][ny] > map[x][y]) {
                    dfs(map, nx, ny, count);
                }
            }
        }
    }
}