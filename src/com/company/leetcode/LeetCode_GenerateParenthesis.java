package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/26
 * Time: 5:17 오후
 */
public class LeetCode_GenerateParenthesis {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();

        dfs(n, 0, 0, "", result);

        return result;
    }

    public static void dfs(int n, int open, int close, String temp, List<String> result) {
        if (open == n && close == n) {
            result.add(temp);
            return;
        }

        if (n > open) {
            //System.out.println(temp + "fir");
            dfs(n, open + 1, close, temp + "(", result);

        }

        if (close < open) {
            System.out.println(temp + "sec");
            dfs(n, open, close + 1, temp + ")", result);
        }
    }
}
