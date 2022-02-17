package com.company.boj.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/17
 * Time: 12:28 오후
 * desc: 부모 노드를 찾는 방법. 이것도 외워두면 좋을 듯
 */
public class BOJ_11725_트리의부모찾기 {

    public static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        ArrayList<Integer>[] tree = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];

        // 1부터 시작 할 것이기 때문에 다음과 같이 처리
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int one = scan.nextInt();
            int two = scan.nextInt();

            tree[one].add(two);
            tree[two].add(one);
        }

        dfs(tree, visited, parent, 1);

        // 1부터 시작해야 하므로 i 는 2부터 반복 시작
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(List<Integer>[] list, boolean[] visited, int[] parent, int depth) {

        // 현재 탐색중인 노드와 연결되어있는 노드들을 for문을 통해서 가져오고
        for (int i : list[depth]) {
            // 노드에 연결되어있는 녀석들 중에 방문하지 않은 녀석들이 있다면
            if (!visited[i]) {
                // 부모 노드는 항상 먼저 방문한다는 원리를 이용하여 현재 노드에 연결되어 탐색중인 노드의 부모 노드로 설정한다.
                parent[i] = depth;
                // 탐색을 했던 노드는 항상 방문 처리
                visited[depth] = true;
                dfs(list, visited, parent, i);
            }
        }
    }
}