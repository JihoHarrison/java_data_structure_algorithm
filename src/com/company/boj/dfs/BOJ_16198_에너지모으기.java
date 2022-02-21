package com.company.boj.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/22
 * Time: 12:36 오전
 */
public class BOJ_16198_에너지모으기 {

    private static int power = 0;
    private static int N;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(scan.nextInt());
        }

        dfs(list, 0, N);
        System.out.println(power);
    }

    public static void dfs(List<Integer> list, int weight, int n) {

        if(n == 2) {

            power = Math.max(power, weight);
            return;
        }

        // 0번째 -> 첫번째 선택 불가, (list.size() - 1)번째 -> 마지막 요소 선택 불가
        for(int i = 1; i < list.size() - 1; i++) {
            // 에너지 값 계산
            int s = list.get(i - 1) * list.get(i + 1);
            // i 번째는 제거해주고
            int temp = list.remove(i);
            // 해당 i 번째가 제거된 상태로 재귀
            dfs(list, weight + s, n - 1);
            // i 번째 제거된 상태로 n == 2까지 재귀가 끝났다면 다시 값 돌려놓기
            list.add(i, temp);
        }
    }
}