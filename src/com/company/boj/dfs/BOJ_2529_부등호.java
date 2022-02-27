package com.company.boj.dfs;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/27
 * Time: 4:29 오후
 */
public class BOJ_2529_부등호 {

    private static int K;
    private static char[] oper;
    private static boolean[] visited;
    private static TreeSet<String> set;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        K = scan.nextInt();

        oper = new char[K];
        visited = new boolean[10];
        set = new TreeSet<String>();

        for (int i = 0; i < K; i++) {
            oper[i] = scan.next().charAt(0);
        }

        dfs("", 0);

        System.out.println(set.last());
        System.out.println(set.first());
    }

    private static void dfs(String num, int depth) {

        if (depth == K + 1) {

            set.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (depth == 0 || !visited[i] && check(num.charAt(num.length() - 1) - '0', i, oper[depth - 1])) {
                visited[i] = true;
                dfs(num + i, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean check(int a, int b, char c) {
        if (c == '>') return a > b;
        else return a < b;
    }
}