package com.company.techtaka;

import java.util.*;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/20
 * Time: 1:30 오후
 * desc: 배열 요소 빈도 횟수에 따라 정렬
 */
public class FrequencyArray {


    public static void main(String[] args) {

        int[] arr = {4, 1, 1, 2, 2, 2, 2, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3};

        frequency(arr);
    }

    private static void frequency(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 0);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        // map을 key나 value에 따라서 정렬 할 때 다음과 같이 사용해야 한다.
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, ((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.print(entry.getKey() + " ");
        }
    }
}