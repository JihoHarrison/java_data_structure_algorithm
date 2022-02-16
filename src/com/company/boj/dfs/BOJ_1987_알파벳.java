package com.company.boj.dfs;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/16
 * Time: 12:40 오후
 */
public class BOJ_1987_알파벳 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public static int answer = 0;
    public static int count = 0;

    public static void main(String[] args) {

//        char[][] list = {
//                {'C', 'A', 'A', 'B'},
//                {'A', 'D', 'C', 'B'}
//        };

        char[][] list = {
                {'H', 'F', 'D', 'F', 'F', 'B'},
                {'A', 'J', 'H', 'G', 'D', 'H'},
                {'D', 'G', 'A', 'G', 'E', 'H'}
        };

        int[][] listPosition = new int[list.length][list[0].length];

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                listPosition[i][j] = list[i][j] - 'A';
            }
        }

        boolean[] visited = new boolean[26];

        // 말이 지나는 칸은 좌측 상단의 칸도 포함 된다. 이조건에 의해 처음 할당될 때 1을 초기값으로 지정
        dfs(list, listPosition, visited, 0, 0, 1);

        System.out.println(count);
    }


    public static void dfs(char[][] list, int[][] listPosition, boolean[] visited, int x, int y, int cnt) {

        visited[listPosition[x][y]] = true;
        count = Math.max(count, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= list.length || ny >= list[0].length) continue;
            if (!visited[listPosition[nx][ny]]) {
                dfs(list, listPosition, visited, nx, ny, cnt + 1);
                visited[listPosition[nx][ny]] = false;
            }
        }
    }
}
