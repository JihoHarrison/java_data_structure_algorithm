package com.company.bok.dfs;

import java.util.*;

class BOK2210_JIn {
    public static int[] arr;
    public static boolean[] visited;
    public static ArrayList<int[]> answerSet = new ArrayList<>();


    public static int solution(int[][] board, int size, int num) {
        arr = new int[num];
        visited = new boolean[num];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                int[] start = {r, c};
                dfs(board, start, 0, num);
            }
        }
        return answerSet.size();
    }

    public static void dfs(int[][] board, int[] start, int idx, int num) {
        arr[idx] = board[start[0]][start[1]];
        if (idx == num - 1) {
            int[] answer = new int[num];
            for (int i = 0; i < num; i++) {
                answer[i] = arr[i];
                System.out.print(answer[i]);
            }
            System.out.println();
            boolean existed = false;
            for (int[] ans : answerSet) {
                boolean match = true;
                for (int i = 0; i < ans.length; i++) {
                    if (answer[i] != ans[i]) {
                        match = false;
                        break;
                    }
                }
                if (match)
                    existed = true;
            }
            if (!existed) {
                answerSet.add(answer);
            }

        }

        int[] row = {0, 0, 1, -1};
        int[] column = {1, -1, 0, 0};
        for (int n = idx; n < num; n++) {
            visited[idx] = true;
            if (!visited[n]) {
                for (int i = 0; i < 4; i++) {
                    int[] node = new int[2];
                    node[0] = start[0] + row[i];
                    node[1] = start[1] + column[i];
                    boolean ps = true;
                    for (int nd : node) {
                        if (nd < 0 || nd > 4) {
                            ps = false;
                            break;
                        }
                    }
                    if (!ps) continue;
                    dfs(board, node, n, num);
                }
            }
            visited[idx] = false;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 2, 1}, {1, 1, 1, 1, 1}};
        System.out.println(solution(board, 5, 6));
    }
}
