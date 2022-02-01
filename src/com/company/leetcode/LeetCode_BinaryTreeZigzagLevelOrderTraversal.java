package com.company.leetcode;

import java.util.*;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/01
 * Time: 1:18 오후
 */
public class LeetCode_BinaryTreeZigzagLevelOrderTraversal {

    public class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(0, root, list);
        return list;
    }

    public static void dfs(int level, TreeNode node, List<List<Integer>> result) {
        if (node == null) return;
        if (level == result.size()) result.add(new ArrayList<Integer>());
        if (level % 2 == 0) result.get(level).add(0, node.value);
        else result.get(level).add(node.value);
        dfs(level + 1, node.left, result);
        dfs(level + 1, node.right, result);
    }
}