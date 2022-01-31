package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/31
 * Time: 4:54 오후
 */
public class LeetCode_BinaryTreeInorderTraversal {

    public static void main(String[] args) {

        TreeNode node;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();

        dfs(root, list);

        return list;

    }

    public static void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}