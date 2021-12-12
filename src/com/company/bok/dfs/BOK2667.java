package com.company.bok.dfs;

import java.util.*;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/09
 * Time: 12:31 오후
 */
public class BOK2667 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static int N;
    public static int count = 0;
    public static int[][] arr = new int[25][25];
    public static int[] answers = new int[625];
    public static boolean[][] isVisited = new boolean[25][25];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            String str = scan.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !isVisited[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
        Arrays.sort(answers);

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] != 0) System.out.println(answers[i]);
        }
    }

    public static void dfs(int x, int y) {

        isVisited[x][y] = true;
        answers[count]++;

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX < 0 || nowY < 0 || nowX >= N || nowY >= N) continue;

            if (arr[nowX][nowY] == 1 && !isVisited[nowX][nowY]) {
                dfs(nowX, nowY);
            }
        }
    }
}