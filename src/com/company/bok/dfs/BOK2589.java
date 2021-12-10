package com.company.bok.dfs;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/10
 * Time: 4:27 오후
 */
public class BOK2589 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};


    public static int L;
    public static int W;

    public static char[][] arr;
    public static boolean[][] visited;
    public static char[] results;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        L = scan.nextInt();
        W = scan.nextInt();

        arr = new char[L][W];
        visited = new boolean[L][W];
        results = new char[L * W];

        for(int i = 0; i < L; i++) {
            for(int j = 0; j < W; j++) {
                dfs(i, j);
            }
        }



    }

    public static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (0 > nowX || nowX >= L || 0 > nowY || nowY >= W) {
                continue;
            }
            if (arr[nowX][nowY] == 'L' && !visited[nowX][nowY]) {
                //count++;
                dfs(nowX, nowY);
            }
        }


    }


}
