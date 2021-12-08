package com.company.programmers.kakao;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/06
 * Time: 6:08 오후
 */
public class FindWay {

    static int[][] result;
    static int idx;

    public static void main(String[] args) {
        int[][] nodeInfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        solution(nodeInfo);
    }

    public static int[][] solution(int[][] nodeInfo) {

        ArrayList<Node> node = new ArrayList<Node>();

        for (int i = 0; i < nodeInfo.length; i++) {
            node.add(new Node(nodeInfo[i][0], nodeInfo[i][1], i + 1, null, null));
        }

        Collections.sort(node, (n1, n2) -> {
            if (n1.y == n2.y) return n1.x - n2.x;
            else return n2.y - n1.y;
        });

        Node root = node.get(0);

        for (int i = 1; i < node.size(); i++) {
            insertNode(root, node.get(i));
        }

        result = new int[2][nodeInfo.length];

        idx = 0;
        preOrder(root);
        idx = 0;
        postOrder(root);

        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

        return result;


    }

    // 삽입
    public static void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }

    public static void preOrder(Node root) {
        if (root != null) {
            result[0][idx++] = root.data;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            result[1][idx++] = root.data;
        }
    }

    static class Node {
        int x;
        int y;
        int data;
        Node left;
        Node right;

        public Node(int x, int y, int data, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
}
