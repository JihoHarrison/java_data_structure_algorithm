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

    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> lists = new ArrayList<>();
        boolean[] visited = new boolean[n];

        // 양방향 그래프 생성
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int des = edges[i][1];
            lists.get(src).add(des);
            lists.get(des).add(src);
        }

        return dfs(lists, visited, source, destination);

    }

    public static boolean dfs(List<List<Integer>> lists, boolean[] visited, int src, int des) {
        if (src == des) return true;
        visited[src] = true;

        for (int i = 0; i < lists.get(src).size(); i++) {
            if (!visited[lists.get(src).get(i)]) {
                if (dfs(lists, visited, lists.get(src).get(i), des)) return true;
            }
        }

        return false;
    }
}