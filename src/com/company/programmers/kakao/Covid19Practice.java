package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/10/18
 * Time: 12:17 오후
 */
public class Covid19Practice {

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < places.length; i++) {
            answer[i] = solutionPractice(places[i]);
        }
        for (int q = 0; q < 5; q++) {
            System.out.print(answer[q] + " ");
        }
        return answer;
    }

    public static int solutionPractice(String[] places) {
        String[][] table = makeTable(places);

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                int cnt = 0;
                if (table[i][j].equals("X")) continue;
                if (table[i][j].equals("P")) {
                    cnt++;
                }
                if (i > 0) {
                    if (table[i - 1][j].equals("P")) {
                        cnt++;
                    }
                }
                if (i < table.length - 1) {
                    if (table[i + 1][j].equals("P")) {
                        cnt++;
                    }
                }
                if (j > 0) {
                    if (table[i][j - 1].equals("P")) {
                        cnt++;
                    }
                }
                if (j < table[i].length - 1) {
                    if (table[i][j + 1].equals("P")) {
                        cnt++;
                    } else {
                        cnt += 0;
                    }
                }
                if (cnt >= 2) {
                    return 0;
                }
            }
        }
        return 1;
    }


    public static String[][] makeTable(String[] places) {
        String[][] newCusTable = new String[5][5];
        for (int i = 0; i < places.length; i++) {
            String[] str = places[i].split("");
            for (int j = 0; j < str.length; j++) {
                newCusTable[i][j] = str[j];
                System.out.println(newCusTable[i][j]);
            }
            System.out.println();
        }
        return newCusTable;
    }
}
