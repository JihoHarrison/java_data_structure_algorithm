package com.company.boj.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/16
 * Time: 3:10 오후
 * desc: PriorityQueue를 쓸까 했지만 ArrayList가 더 쉽게 적용 될 것 같음. 그래서 ArrayList 썼어요.
 */
public class BOJ_2583_영역구하기 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static int M;
    public static int N;
    public static int K;
    public static int[][] map;
    public static int count;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();

        map = new int[M][N];
        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            for (int a = y1; a < y2; a++) {
                for (int b = x1; b < x2; b++) {
                    map[a][b] = 1;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    count = 0;
                    dfs(map, i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        System.out.print(list);
    }


    public static void dfs(int[][] map, int x, int y) {

        map[x][y] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (map[nx][ny] == 0) {
                    dfs(map, nx, ny);
                }
            }
        }

    }
}