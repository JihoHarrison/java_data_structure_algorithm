package com.company.boj.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/19
 * Time: 8:53 오후
 * desc: Gold3 정도의 어려웠던 문제.
 */
public class BOJ_1167_트리의지름 {

    private static int V;
    private static int max = 0;
    private static int node = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        V = scan.nextInt();

        List<Node>[] list = new ArrayList[V + 1];
        boolean[] visited;

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {

            int node = scan.nextInt();

            while (true) {
                int e = scan.nextInt();

                if (e == -1) break;

                int cost = scan.nextInt();

                list[node].add(new Node(e, cost));
            }
        }

        // 임의의 노드부터 가장 먼 거리의 노드를 구하고, 또 거기서부터 최장거리 노드를 구하면 그것이 바로 트리의 최장거리. (지름)
        visited = new boolean[V + 1];
        dfs(1, 0, visited, list);

        // 임의의 노드부터 가장 먼 거리의 노드는 node 변수에 저장해서 node부터 최장거리 노드를 구하면서 max 값 카운팅 해주면 트리의 지름이 나온다.
        visited = new boolean[V + 1];
        dfs(node, 0, visited, list);

        System.out.print(max);
    }

    private static void dfs(int start, int depth, boolean[] visited, List<Node>[] lists) {

        if (depth > max) {
            max = depth;
            node = start;
        }
        
        // 1번 노드부터 곧바로 방문.
        visited[start] = true;

        for (int i = 0; i < lists[start].size(); i++) {
            Node n = lists[start].get(i);
            if (!visited[n.e]) {
                dfs(n.e, depth + n.cost, visited, lists);
            }
        }
    }

    static class Node {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}
