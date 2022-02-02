package com.company.programmers;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/02
 * Time: 3:04 오후
 */
public class Programmers_프렌즈4블록 {

    public static void main(String[] args) {

        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(6, 6, board));

    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean letsCrash = true;
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // i j로 하면 안됨. 주의.
                map[j][i] = board[i].charAt(j);
            }
        }

        while (letsCrash) {
            letsCrash = false;

            // 한 번 돌 때 마다 부숴줘야 하는 부분을 새롭게 판별해야 하므로 while문 안쪽에서 생성
            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {

                    if (map[i][j] == '0') continue;

                    if (map[i][j] == map[i + 1][j] && map[i + 1][j] == map[i + 1][j + 1]
                            && map[i][j + 1] == map[i + 1][j + 1] && map[i][j + 1] == map[i][j]) {
                        visited[i][j] = true;
                        visited[i + 1][j + 1] = true;
                        visited[i + 1][j] = true;
                        visited[i][j + 1] = true;

                        letsCrash = true;
                    }
                }
            }

            // 팝 해야 할 곳을 판별 후 팝 한다음 빈자리 채워주기
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        answer++;
                        for (int k = j - 1; k >= 0; k--) {
                            map[i][k + 1] = map[i][k];
                            map[i][k] = '0';
                        }
                    }
                }
            }
        }
        return answer;
    }
}