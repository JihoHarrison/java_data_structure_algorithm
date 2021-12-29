package com.company.bok.dfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho4
 * Date: 2021/12/12
 * Time: 3:38 오후
 */
public class BOJ2667Second {
    private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
    private static int[] aparts = new int[25 * 25];
    private static int n;
    private static int apartNum = 0; //아파트 단지 번호의 수
    private static boolean[][] visited = new boolean[25][25]; //방문여부
    private static int[][] map = new int[25][25]; //지도

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];
        visited = new boolean[n][n];

        //전체 사각형 입력 받기
        for (int i = 0; i < n; i++) {
            String input = sc.next(); // "1 0 1 1 0 0 0 1"
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0'; // '1' - '0' = 1   //   '13' - '0' = 13
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    apartNum++;
                    dfs(i, j);
                }
            }
        }

        Arrays.sort(aparts);
        System.out.println(apartNum);

        for (int i = 0; i < aparts.length; i++) {
            if(aparts[i] != 0) System.out.println(aparts[i]);
        }
    }

    private static void dfs(int x, int y) { //  1 0 1 0 0 0 0
                                            //  0 0 1 0 1 0 0
        visited[x][y] = true;
        aparts[apartNum]++; // 6 , 2 , 1 , 0 , 0 ,0 ,0 0 ......... 625

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}