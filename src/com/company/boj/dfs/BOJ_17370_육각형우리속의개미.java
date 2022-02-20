package com.company.boj.dfs;

import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/20
 * Time: 11:25 오후
 * desc: 크기가 정해져 있지 않은 판에서 6각형의 6 방향에 대해 탐색 해야 하는 문제.. 그냥 이해하고 넘어가기로..
 */
public class BOJ_17370_육각형우리속의개미 {

    static boolean[] chk = new boolean[2001];
    static int[] weight = { 23, 1, 1, -23, -1, -1 };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 몇번 인지 입력

        chk[100] = true;

        System.out.println(calc(n, 100 + weight[0], 0));
    }

    static int calc(int cnt, int cur, int w) {
        if (cnt == 0) {
            if (chk[cur])
                return 1;
            else
                return 0;
        }
        if (chk[cur])
            return 0;

        chk[cur] = true;
        int temp = calc(cnt - 1, cur + weight[(w + 5) % 6], (w + 5) % 6)
                + calc(cnt - 1, cur + weight[(w + 1) % 6], (w + 1) % 6);
        chk[cur] = false;
        return temp;
    }


}
