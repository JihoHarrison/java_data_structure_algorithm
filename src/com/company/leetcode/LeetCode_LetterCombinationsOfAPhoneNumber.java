package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/26
 * Time: 1:10 오전
 */
public class LeetCode_LetterCombinationsOfAPhoneNumber {

    public static boolean[] visited;
    public static String[] phoneNumbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {

        String digits = "234";

        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> temp = new ArrayList<String>();

        if(digits.length() == 0) return temp;

        dfs("", digits, 0, temp);

        return temp;

    }

    public static void dfs(String prefix, String digit, int depth, List<String> ret) {

        if(depth >= digit.length()) { // 탐색을 할 노드의 개수를 판별
            ret.add(prefix);
            return;
        }

        String letters = phoneNumbers[digit.charAt(depth) - '0'];

        for(int i = 0; i < letters.length(); i++) {
            dfs(prefix + letters.charAt(i), digit, depth + 1, ret);
        }
    }
}