package com.company.programmers;

import java.util.TreeSet;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/01
 * Time: 5:44 오후
 */
public class Programmers_가장큰수 {

    public static void main(String[] args) {

        //int[] numbers = {6, 10, 2};
        int[] numbers = {3, 30, 34, 5, 9};
        //int[] numbers = {0, 0, 0, 0, 00, 000, 00000};

        System.out.println(solution(numbers));

    }

    public static String solution(int[] numbers) {
        String answer = "";
        boolean[] visited = new boolean[numbers.length];
        TreeSet<Integer> treeset = new TreeSet<Integer>();

        dfs(0, "", numbers, visited, treeset);
        System.out.println(treeset);

        answer = String.valueOf(treeset.last());

        return answer;
    }

    public static void dfs(int depth, String value, int[] numbers, boolean[] visited, TreeSet<Integer> treeset) {
        if (depth == numbers.length) {
            int val = Integer.parseInt(value);
            treeset.add(val);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, value + numbers[i], numbers, visited, treeset);
                visited[i] = false;
            }
        }
    }
}
