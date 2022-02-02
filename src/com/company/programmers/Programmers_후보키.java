package com.company.programmers;

import java.util.*;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/02
 * Time: 1:11 오후
 * desc: 후보키 다시 풀기
 */
public class Programmers_후보키 {

    public static List<String> lists = new ArrayList<>();
    public static Set<Integer> set = new HashSet<>();
    public static boolean[] visited;

    public static void main(String[] args) {

        String[][] str = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        solution(str);

    }

    public static int solution(String[][] relation) {
        int answer = 0;
        visited = new boolean[relation[0].length];

        for(int i = 0; i < visited.length; i++) {
            dfs(0, i + 1, visited, relation);
        }

        return answer;
    }

    public static void dfs(int depth, int end, boolean[] visited, String[][] relation) {

        if(depth == end) {
            List<Integer> col = new ArrayList<>();
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    col.add(i);
                    System.out.println(col.get(i));
                }
            }

        }


        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, end, visited, relation);
                visited[i] = false;
            }
        }


    }


}