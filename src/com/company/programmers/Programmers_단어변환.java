package com.company.programmers;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/15
 * Time: 1:42 오후
 * desc: 걍 문제 조건이 명확하지 않은게 조오금 이상한듯..?
 */
public class Programmers_단어변환 {

    public static int answer = 0;

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        solution(begin, target, words);
    }

    public static int solution(String begin, String target, String[] words) {

        boolean[] visited = new boolean[words.length];
        // 단어가 한 번도 교체되지 않을 경우를 판별
        answer = 100;
        System.out.println(words.length);

        dfs(begin, target, words, visited, 0);

        System.out.println(answer);
        System.out.println(words.length);
        return answer == 100 ? 0 : answer;
    }

    public static void dfs(String begin, String target, String[] words, boolean[] visited, int count) {

        if (target.equals(begin)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            int k = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(words[i], target, words, visited, count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}