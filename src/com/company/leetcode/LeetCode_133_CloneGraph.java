package com.company.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/28
 * Time: 8:00 오후
 */
public class LeetCode_133_CloneGraph {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {

        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();

        return dfs(map, node);
    }

    private static Node dfs(Map<Node, Node> map, Node n) {

        if (map.containsKey(n)) return map.get(n);

        Node newNode = new Node(n.val);

        map.put(n, newNode);

        for (Node child : n.neighbors) {
            newNode.neighbors.add(dfs(map, child));
        }

        return newNode;
    }
}
