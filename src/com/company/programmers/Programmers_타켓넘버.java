package com.company.programmers;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/15
 * Time: 1:46 오전
 */
public class Programmers_타켓넘버 {

    public static int count = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        solution(numbers, 3);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(numbers, 0, target, 0);
        answer = count;
        System.out.println(answer);
        return answer;
    }

    public static void dfs(int[] numbers, int sum, int target, int depth) {

        if (depth == numbers.length) {
            if (sum == target) count++;
            return;
        }

        dfs(numbers, sum + numbers[depth], target, depth + 1);
        dfs(numbers, sum - numbers[depth], target, depth + 1);
    }
}
