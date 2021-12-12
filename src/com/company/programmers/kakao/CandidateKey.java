package com.company.programmers.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/06
 * Time: 6:08 오후
 */
public class CandidateKey {

    public static void main(String[] args) {

        String[][] tables = {{
                "100", "ryan", "music", "2"
        }, {
                "200", "apeach", "math", "2"
        }, {
                "300", "tube", "computer", "3"
        }, {
                "400", "con", "computer", "4"
        }, {
                "500", "muzi", "music", "3"
        }, {
                "600", "apeach", "music", "2"
        }};

        solution(tables);
    }

    public static List<String> candi = new ArrayList<>();

    public static int solution(String[][] relation) {
        int answer = 0;

        for (int i = 0; i < relation[0].length; i++) { // 4
            boolean[] visited = new boolean[relation[0].length];
            //System.out.print(i);
            dfs(visited, 0, i + 1, relation);
        }

        answer = candi.size();
        //System.out.println(answer);
        return answer;
    }

    public static void dfs(boolean[] visited, int depth, int end, String[][] relation) {
        // 최소성을 만족시키는 세로 조합의 갯수를 계속 찾아주는 부분
        if (depth == end) {
            List<Integer> list = new ArrayList<>();
            String key = "";
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    key += String.valueOf(i); // 01
                    list.add(i); // 0 , 1        1, 2       0, 3    이런 부분 걸러주는 애
                }
            }
            // 어차피 한 행 탐색하면 그 행에 대한 판별은 종료되기 때문에 재귀때마다 계속 새롭게 초기화
            Map<String, Integer> map = new HashMap<>();

            // 중복되는 키 값 있는지 걸러주는 애 중복되면 그냥 리턴
            for (int i = 0; i < relation.length; i++) {
                String s = "";
                for (Integer j : list) {
                    s += relation[i][j]; // 200apeach
                }

                if (map.containsKey(s)) {
                    return;
                } else {
                    map.put(s, 0); // 100ryan, 0    200apeach, 0  ... 600apeach, 0
                }
            }

            // 후보키 추가
            for (String s : candi) { // 0
                //System.out.println(s + "  !!!!");
                //System.out.println("candi : " + candi);

                int count = 0;
                for (int i = 0; i < key.length(); i++) {// 0, 1

                    String subS = String.valueOf(key.charAt(i)); // 0, 1
                    //System.out.println("key : " + key);
                    //System.out.println("subS : " + subS);
                    //System.out.println("s : " + s);
                    if (s.contains(subS)) count++; // 2
                }
                //System.out.println();
                if (count == s.length()) return;
            }
            candi.add(key);

            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(visited, depth + 1, end, relation);
                visited[i] = false;
            }
        }
    }
}
