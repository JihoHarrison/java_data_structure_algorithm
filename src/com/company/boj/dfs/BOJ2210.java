package com.company.boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/17
 * Time: 8:12 오후
 */
public class BOJ2210 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static int[][] arr = new int[5][5];
    public static List answer = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            String str = "";
            for (int j = 0; j < 5; j++) {
                while(st.hasMoreTokens())
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, "");
            }
        }
    }

    public static void dfs(int x, int y, int depth, String str) {

        if (depth == 6) {
            if (!answer.contains(str)) {
                answer.add(str);
                System.out.println(str);
            }
            return;
        }

        for (int j = 0; j < 4; j++) {
            int nowX = x + dx[j];
            int nowY = y + dy[j];

            if (0 > nowX || nowX >= 5 || 0 > nowY || nowY >= 5) {
                continue;
            }
            dfs(nowX, nowY, depth + 1, str + arr[x][y]);
        }
    }
}