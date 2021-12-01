package com.company.programmers.kakao;

import java.util.*;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/01
 * Time: 12:11 오전
 */
public class MenuRenewer {

    public static List<String> comb;

    public static void main(String[] args) {
        String[] answer;

        comb = new ArrayList<String>();

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        for (int i = 0; i < orders.length; i++) {
            char[] orderCharArray = orders[i].toCharArray();
            for (int j = 0; j < orderCharArray.length - 1; j++) {
                for (int k = 0; k < course.length; k++) {
                    dfs(orderCharArray, j, 1, course[k], String.valueOf(orderCharArray[j]));
                }
            }
        }

//        for (String str : comb) {
//            System.out.println(str);
//        }

        Map<String, Integer> map = new HashMap<>();
        for (String key : comb) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int max_value = 0;

            for (String key : keySetList) {
                if (map.get(key) >= 2 && key.length() == course[i]) {
                    if (map.get(key) >= max_value) {
                        ansList.add(key);
                        max_value = map.get(key);
                    }
                }
            }
        }
        Collections.sort(ansList);
        answer = new String[ansList.size()];
        ansList.toArray(answer);

        for (int i = 0; i < ansList.size(); i++) {
            System.out.println(ansList.get(i));
        }
    }


    public static void dfs(char[] arr, int idx, int length, int course, String str) {
        if (length == course) {
            comb.add(str);
        }

        for (int i = idx + 1; i < arr.length; i++) {
            dfs(arr, i, length + 1, course, str + arr[i]);
        }
    }
}
