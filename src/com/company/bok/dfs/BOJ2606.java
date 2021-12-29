package com.company.bok.dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/08
 * Time: 3:09 오후
 */
public class BOJ2606 {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int node = scan.nextInt();
        int link = scan.nextInt();
        boolean[] visited = new boolean[node + 1];
        ArrayList<Integer>[] lists = new ArrayList[node + 1];
        //ArrayList<ArrayList<Integer>> lists = new ArrayList<>(node + 1); -> 이거 디폴트 크기 설정이 안돼서 밑에서 한 번 더 list = new ArrayList<Integer>(); 해줘야함. 0번째 배열 사용 안하려면
        System.out.println(lists.length);


        for (int i = 1; i <= node; i++) {
            lists[i] = new ArrayList<Integer>();
        }

        // 이건 그냥 여섯 번 만
        for (int i = 0; i < link; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            lists[x].add(y);
            lists[y].add(x);
        }
//        Iterator로 출력하는 부분
//        for (int i = 0; i < lists.size(); i++) {
//            Iterator<Integer> iter = lists.get(i).iterator();
//
//            System.out.print(i + " -> ");
//            while (iter.hasNext()) {
//                System.out.print(iter.next() + " ");
//            }
//            System.out.println();
//        }
        System.out.println(lists.length);
        System.out.println(dfs(1, visited, lists));
    }

    public static int dfs(int start, boolean[] visited, ArrayList<Integer>[] lists) {
        visited[start] = true;
        for (int k : lists[start]) {
            if (!visited[k]) {
                count++;
                dfs(k, visited, lists);
            }
        }
        return count;
    }
}
