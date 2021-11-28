package com.company.bok.dfs;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/17
 * Time: 8:12 오후
 */
public class BOK2210 {

    public static int[][] arr = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 2, 1}, {1, 1, 1, 1, 1}};
    public static boolean[][] visited = new boolean[5][5];
    public static int[] answer = new int[6];

    public static void main(String[] args) {

        dfs(0, 0, 0, 0);

    }

    public static void dfs(int x, int y, int cnt, int depth) {

        if (depth == answer.length) {

            for (int i = 0; i < 6; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        // 위로 이동 가능하면 이동
        if (y >= 0) {
            if (y - 1 < 0) {
                y = 5;
            }
            if (!visited[y - 1][x]) {
                visited[y - 1][x] = true;
                answer[cnt + 1] = arr[y - 1][x];
                dfs(x, y - 1, cnt, depth + 1);
            }
        }
        // 아래로 이동할 수 있다면 이동
        if (y <= 5 - 1) {
            if (y >= 4) {
                y = 0;
            }
            if (!visited[y + 1][x]) {
                visited[y + 1][x] = true;
                answer[cnt + 1] = arr[y + 1][x];
                dfs(x, y + 1, cnt, depth + 1);
            }

        }
        visited[y][x] = false;


    }

}
