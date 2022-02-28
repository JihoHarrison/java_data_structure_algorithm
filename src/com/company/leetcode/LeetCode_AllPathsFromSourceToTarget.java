package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/28
 * Time: 4:50 오후
 */
public class LeetCode_AllPathsFromSourceToTarget {

    public static void main(String[] args) {

        int[][] graph = {{1, 2}, {3}, {3}, {}};
        //[4,3,1],[3,2,4],[3],[4],[]
        int[][] graph2 = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};

        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<Integer>[] list = new ArrayList[graph.length];
        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                list[i].add(graph[i][j]);
                //list[graph[i][j]].add(i);
            }
        }

        dfs(list, 0, answer, path, visited);

        return answer;
    }

    private static void dfs(List<Integer>[] list, int start, List<List<Integer>> answer, ArrayList<Integer> path, boolean[] visited) {
        path.add(start);
        if (start == list.length - 1) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < list[start].size(); i++) {
            //  if (!visited[list[start].get(i)]) {
            //  visited[list[start].get(i)] = true;
            dfs(list, list[start].get(i), answer, path, visited);
            // visited[list[start].get(i)] = false;
            path.remove(path.size() - 1);
        }

    }
}

