package com.company.boj.dfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/27
 * Time: 3:15 오후
 */
public class BOJ_1759_암호만들기 {

    private static int L;
    private static int C;
    private static char[] map;
    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        L = scan.nextInt();
        C = scan.nextInt();
        map = new char[C];
        visited = new boolean[C];

        for (int i = 0; i < C; i++) {
            map[i] = scan.next().charAt(0);
        }

        Arrays.sort(map);

        dfs(0, 0);
    }

    private static void dfs(int start, int cnt) {

        if (cnt == L) {

            int vowels = 0;
            int consonants = 0;

            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    if (map[i] == 'a' || map[i] == 'e' || map[i] == 'i' || map[i] == 'o' || map[i] == 'u') {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
            }

            if (vowels >= 1 && consonants >= 2) {
                for (int j = 0; j < C; j++) {
                    if (visited[j]) System.out.print(map[j] + " ");
                }
                System.out.println();
            }

            return;
        }

        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}