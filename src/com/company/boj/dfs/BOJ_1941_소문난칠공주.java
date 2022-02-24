package com.company.boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/24
 * Time: 4:32 오후
 * desc: bfs로 인접한 공주들 탐색하는 로직을 dfs로 바꿔봐야겠다.
 */
public class BOJ_1941_소문난칠공주 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    private static int n = 5;
    private static int totalCount = 0;
    private static char[][] map = new char[n][n];
    private static boolean[] visited = new boolean[n * n];
    static boolean adjVisited[] = new boolean[n * n];
    private static int[] princess = new int[7];
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 0);

        System.out.print(totalCount);
    }

    public static void dfs(int index, int depth, int somCount) {

        if (depth == 7) {
            if (somCount >= 4) {
                if (checkAdj()) {
                    totalCount++;
                }
                return;
            }
            return;
        }

        for (int i = index; i < n * n; i++) {
            visited[i] = true;

            princess[depth] = i;
            if (map[i / n][i % n] == 'S') dfs(i + 1, depth + 1, somCount + 1);
            else dfs(i + 1, depth + 1, somCount);

            visited[i] = false;
        }
    }

    private static boolean checkAdj() {

        int cnt = 1;
        q = new LinkedList<>();
        adjVisited = new boolean[n * n];

        // 임의로 선택해서 queue에 넣어어준 학생.
        // 여기서 princess array는 위에 dfs에서 만들어진 배열이다.
        // 이 7개의 값을 가지고 임의의 한 노드를 선택하고 bfs로 연결되었는지 확인해준다.
        q.add(princess[0]);

        while (!q.isEmpty()) {

            int now = q.poll();

            adjVisited[now] = true;

            for (int i = 0; i < 4; i++) {

                int nx = (now / n) + dx[i];
                int ny = (now % n) + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                // 이미 확인 한 아이
                if (adjVisited[nx * n + ny]) continue;
                // 인접한 아이인데 뽑은 (방문한) 공주가 아니라면 pass
                if (!visited[nx * n + ny]) continue;

                cnt++;
                adjVisited[nx * n + ny] = true;
                q.add(nx * n + ny);
            }
        }

        if (cnt == 7) return true;
        else return false;
    }
}