package com.company.programmers;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/23
 * Time: 12:09 오전
 */
public class Programmers_소수찾기 {

    public static boolean[] visited;

    public static void main(String[] args) {

    }

    public static int solution(String numbers) {
        int answer = 0;

        int[] strNumbers = new int[numbers.length()];
        visited = new boolean[numbers.length()];

        for(int i = 0; i < strNumbers.length; i++) {
            strNumbers[i] = numbers.charAt(i) - '0';
        }




        return answer;
    }


    public static void dfs(int start, String[] numbers) {


        for(int i = 0; i < numbers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i + 1, numbers);
                visited[i] = false;
            }
        }
    }



}
