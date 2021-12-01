package com.company.programmers.kakao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/01
 * Time: 12:11 오전
 */
public class MenuRenewer {

    public static List<String> comb;

    public static String[] order = new String[]{};

    public static void main(String[] args) {
        comb = new ArrayList<String>();

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        for (int i = 0; i < orders.length; i++) {
            char[] orderCharArray = orders[i].toCharArray();
            for (int j = 0; j < orderCharArray.length - 1; j++) {
                for (int k = 0; k < course.length; k++) {
                    dfs(orderCharArray, j, 0, course[k], String.valueOf(orderCharArray[j]));
                }
            }
        }



    }

    public static void dfs(char[] arr, int idx, int depth, int course, String str) {
        if (depth == course) {
            comb.add(str);
        }

        for (int i = idx + 1; i < arr.length; i++) {
            dfs(arr, i, depth + 1, course, str + arr[i]);
        }
    }


}
