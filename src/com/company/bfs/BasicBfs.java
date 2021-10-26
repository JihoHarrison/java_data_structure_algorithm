package com.company.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/10/26
 * Time: 4:45 오후
 */
public class BasicBfs {

    public static void main(String[] args) {

        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        boolean[] visited = new boolean[graph.length];
        ArrayList<Integer> answer = new ArrayList<>();

        bfs(answer, 1, graph, visited);

        for(int i : answer){
            System.out.print(i + "  ");
        }
    }

    public static ArrayList<Integer> bfs(ArrayList<Integer> answer ,int start, int[][] graph, boolean[] visited){

        Queue<Integer> q = new LinkedList<Integer>();
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int now = q.poll();
            answer.add(now);

            for(int i = 0; i < graph[now].length; i++){
                int temp = graph[now][i];

                if(!visited[temp]){
                    visited[temp] = true;
                    q.offer(temp);
                }
            }
        }
        return answer;
    }

}
