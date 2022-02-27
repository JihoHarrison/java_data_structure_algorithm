package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/12
 * Time: 10:44 오전
 */
public class LeetCode_FindIfPathExistInGraph {

    public static void main(String[] args) {

        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int n = 3;
        int source = 0;
        int destination = 2;

        System.out.println(validPath(n, edges, source, destination));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        List<Integer>[] list = new ArrayList[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];

            list[src].add(dest);
            list[dest].add(src);
        }

        return dfs(source, destination, list, visited);
    }

    private static boolean dfs(int start, int end, List<Integer>[] list, boolean[] visited) {

        visited[start] = true;

        if (start == end) {
            return true;
        }

        for (int i = 0; i < list[start].size(); i++) {
            if (!visited[list[start].get(i)]) {
                if (dfs(list[start].get(i), end, list, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}