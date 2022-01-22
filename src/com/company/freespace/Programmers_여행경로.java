package com.company.freespace;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/21
 * Time: 10:21 오후
 */
public class Programmers_여행경로 {

    static ArrayList<String> answers;
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        answers = new ArrayList<String>();
        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(answers);

        String[] answer = answers.get(0).split(",");

        return answer;
    }

    public static void dfs(int start, String answer, String now, String[][] tickets) {
        if(start == tickets.length) {
            answers.add(answer);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                dfs(start + 1, answer + "," + tickets[i][1], tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }


}
