package com.company.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/23
 * Time: 12:09 오전
 * desc: 소수찾기. 순열 부르트 포스
 */
public class Programmers_소수찾기 {

    public static boolean[] visited;
    public static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {

        String str = "011";

        System.out.println(solution(str));

    }

    public static int solution(String numbers) {
        int answer = 0;

        int[] strNumbers = new int[numbers.length()];
        visited = new boolean[numbers.length()];

        String[] strArr = new String[strNumbers.length];

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = Character.toString(numbers.charAt(i));
            System.out.println(strArr[i] + " ");
        }

        for (int i = 0; i < strNumbers.length; i++) {
//            strNumbers[i] = numbers.charAt(i) - '0';
//            System.out.print(strNumbers[i] + " ");
            dfs(0, i + 1, "", strArr);
        }

        if (set == null) {
            answer = 0;
        } else {
            answer = set.size();
        }

        return answer;
    }

    public static void dfs(int start, int end, String result, String[] numbers) {

        if (start == end) {
            int n = Integer.parseInt(result);
            if (isPrime(n) && !set.contains(n)) {
                set.add(n);
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(start + 1, end, result += numbers[i], numbers);
                // 탐색 한 번이 끝나고 다른 숫자를 넣어주었을 때 한번 초기화 해준다.
                result = result.substring(0, result.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int n) {
        // 0과 1은 소수가 아니다.
        if (n <= 1) {
            return false;
        }

        // 2나 3은 프리패스
        if (n == 2 || n == 3) {
            return true;
        }

        // 2부터 절반으로 나눈 수 까지 사용하여 쭉 n을 나눠보았을 때
        // 하나라도 나누어 떨어진다면 소수가 아니다.
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        // 위 조건에 걸리지 않으면 소수이므로 true
        return true;
    }
}