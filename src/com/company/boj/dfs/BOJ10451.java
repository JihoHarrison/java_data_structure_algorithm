package com.company.boj.dfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/05
 * Time: 1:43 오전
 * desc: 인접리스트 연습
 */
public class BOJ10451 {

    public static ArrayList<ArrayList<Integer>> adList = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        adList.add(new ArrayList<>());

        for(int i = 0; i < 7; i++) {
            adList.add(new ArrayList<>());
        }

        for(int i = 1; i < 7; i++) {
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            adList.get(v1).add(v2);
            adList.get(v2).add(v1);
        }

        for(int i = 1; i <= 6; i++) {
            Iterator<Integer> iter = adList.get(i).iterator();

            System.out.print(i + " ");
            while (iter.hasNext()){
                System.out.print(iter.next() + " ");
            }
            System.out.println();
        }
    }
}
