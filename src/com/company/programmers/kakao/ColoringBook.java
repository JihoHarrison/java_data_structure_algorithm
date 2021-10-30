package com.company.programmers.kakao;

import java.util.*;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/10/30
 * Time: 7:04 오후
 */
public class ColoringBook {

    public static void main(String[] args) {

    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int[] bfs(int start, int[][] graph, boolean[] visited){

        int[] answer = new int[]{};
        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int now = q.poll();
            answer[cnt++] = now;
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