package com.company.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/18
 * Time: 2:34 오전
 * desc: key에 해당하는 점수의 총 개수 - 점수보다 크거나 같은 처음 index = 특정 점수 이상 점수 개수
 *       걍 너무 어렵다..ㅠㅠ
 */
public class Programmers_순위검색 {

    private static HashMap<String, List<Integer>> map;

    public static void main(String[] args) {


    }


    private static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        map = new HashMap<>();


        for (int i = 0; i < info.length; i++) {

            String[] p = info[i].split(" ");
            dfs(p, "", 0);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            // " and "로 구분되어지는 문자열들 자르고 나서
            query[i] = query[i].replaceAll(" and ", "");
            // 그걸 key값 검색에 사용할 수 있을테니까 조건 - 점수를 공백을 기준으로 분리
            String[] q = query[i].split(" ");

            // 3항 연산자로 q에 해당하는 키 값이 있다면 이분탐색 실행 후 개수 확인. 값이 없다면 0
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }

    private static void dfs(String[] info, String str, int depth) {

        if (depth == 4) {

            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }

            map.get(str).add(Integer.parseInt(info[4]));
        }

        dfs(info, str + "-", depth + 1);
        dfs(info, str + info[depth], depth + 1);
    }

    // 이분탐색
    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (list.get(mid) < score) start = mid + 1;
            else end = mid - 1;
        }

        // key에 해당하는 점수의 총 개수 - 점수보다 크거나 같은 처음 index = 특정 점수 이상 점수 개수
        return list.size() - start;
    }


}
