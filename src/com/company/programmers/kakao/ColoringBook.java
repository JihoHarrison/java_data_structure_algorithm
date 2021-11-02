package com.company.programmers.kakao;

import java.util.*;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/10/30
 * Time: 7:04 오후
 */
public class ColoringBook {
    static boolean[][] visited;
    static int cnt = 0;
    static int[] dx = {1, -1, 0, 0,};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> q = new LinkedList<Node>();

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int [][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        solution(6,4, picture);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] > 0 && !visited[i][j]){
                    cnt = 1;
                    bfs(i, j, m, n, picture);
                    numberOfArea++;
                    if(cnt > maxSizeOfOneArea){
                        maxSizeOfOneArea = cnt;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void bfs(int x, int y, int m, int n, int[][] graph) {
        visited[x][y] = true;
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < m && ny >= 0 && ny < n) {
                    if (graph[nx][ny] == graph[x][y] && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                        // cnt는 면적 계산
                        cnt++;
                    }
                }
            }
        }
    }
}