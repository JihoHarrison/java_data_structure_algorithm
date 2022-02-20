package com.company.programmers.kakao;

import java.util.ArrayList;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/19
 * Time: 4:24 오후
 */
public class Programmers_수식최대화 {

    private static boolean[] visited = new boolean[3];
    private static ArrayList<Long> nums = new ArrayList<>();
    private static ArrayList<Character> ops = new ArrayList<>();
    private static char[] op = {'+', '-', '*'};
    private static long answer = 0;

    public static void main(String[] args) {

        String expression = "100-200*300-500+20";

        System.out.println(solution(expression));
    }

    private static long solution(String expression) {

        //String[] expressArray = expression.split("\\*|-|\\+");
        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num += expression.charAt(i);
            } else {
                nums.add(Long.parseLong(num));
                num = "";
                ops.add(expression.charAt(i));
            }
        }
        // 마지막은 항상 숫자이기 때문에 반복 후 마지막 num 한번 더 add 해줘요.
        nums.add(Long.parseLong(num));

        dfs(0, new char[3]);

        return answer;
    }

    private static void dfs(int depth, char[] p) {

        if (depth == 3) {
            // 수식 중 숫자만을 모아 둔 list
            ArrayList<Long> num = new ArrayList<>(nums);
            // main에서 최대화 된 수식을 구할 수 있는 op 순열의 list
            ArrayList<Character> chOps = new ArrayList<>(ops);

            for (int i = 0; i < p.length; i++) {
                for (int j = 0; j < chOps.size(); j++) {
                    if (p[i] == chOps.get(j)) {
                        long res = calculate(num.remove(j), num.remove(j), p[i]);
                        num.add(j, res);

                        /** 이 조건이 잘 이해가 안갔음. 다시 풀어봐야 할 듯. **/
                        chOps.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(num.get(0)));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                p[depth] = op[i];
                dfs(depth + 1, p);
                visited[i] = false;
            }
        }
    }

    private static long calculate(long a, long b, char op) {
        long result = 0;
        if (op == '*') {
            result = a * b;
        } else if (op == '-') {
            result = a - b;
        } else if (op == '+') {
            result = a + b;
        }

        return result;
    }
}