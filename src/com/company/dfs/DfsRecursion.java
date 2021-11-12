package com.company.dfs;

import java.util.LinkedList;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/10
 * Time: 11:35 오전
 */
public class DfsRecursion {

    public static void main(String[] args) {

        int verticesNum = 6;

        Graph graph = new Graph(verticesNum);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);

        graph.DFSRecursion(0);
    }

    static class Graph {

        int vertices; // 정점의 개수
        LinkedList<Integer>[] adjList; // 인접리스트

        Graph (int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];

            for(int i = 0; i < vertices; i++){
                adjList[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int start, int destination) {
            // adjList[start].add(destination)
            adjList[start].add(destination);
            adjList[destination].add(start);
        }

        public void DFSRecursion(int startVertex) {
            boolean[] visited = new boolean[vertices];
            dfs(startVertex, visited);
        }

        public void dfs(int start, boolean[] visited) {
            visited[start] = true;
            System.out.print(start + " ");
            for(int i = 0; i < adjList[start].size(); i++) {
                int destination = adjList[start].get(i);
                if(!visited[destination]){
                    dfs(destination, visited);
                }
            }
        }
    }
}
