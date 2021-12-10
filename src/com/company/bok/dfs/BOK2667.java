package com.company.bok.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/09
 * Time: 12:31 오후
 */
public class BOK2667 {

    public static int count = 0;
    public static int N = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public static int[][] arr = new int[25][25];
    public static boolean[][] visited = new boolean[25][25];
    public static int[] answer = new int[625];

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            String str = scan.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (arr[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(i, j, arr);
                }
            }
        }

        Arrays.sort(answer);
        System.out.println(count);

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != 0) {
                System.out.println(answer[i]);
            }
        }
    }

    public static void dfs(int x, int y, int[][] arr) {

        visited[x][y] = true;
        answer[count]++;

        for (int j = 0; j < 4; j++) {
            int nowX = x + dx[j];
            int nowY = y + dy[j];

            if (0 > nowX || nowX >= N || 0 > nowY || nowY >= N) {
                continue;
            }
            if (arr[nowX][nowY] == 1 && !visited[nowX][nowY]) {
                //count++;
                dfs(nowX, nowY, arr);
            }
        }
    }
}