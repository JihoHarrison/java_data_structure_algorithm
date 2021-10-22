package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/10/18
 * Time: 12:17 오후
 */
public class Covid19 {

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        int ans = 0;
        for (int i = 0; i < places.length; i++) {
            int sum = 0;
            String[][] cusTable = new String[5][5];
            String[][] newCusTable = new String[5][5];
            for (int j = 0; j < places[i].length; j++) {
                cusTable[i] = places[i][j].split("");
                for (int k = 0; k < 5; k++) { // 여기가 각 문자열의 요소 반복문
                    newCusTable[j][k] = cusTable[i][k];
                }
            }

            for (int l = 0; l < newCusTable.length; l++) {
                int cnt = 0;
                for (int m = 0; m < newCusTable[i].length; m++) {
                    cnt = 0;
                    System.out.print(newCusTable[l][m] + " ");
                    if (newCusTable[l][m].equals("P")) {
                        cnt++;
                        sum++;
                    }
//                    if (newCusTable[l][0].equals("P") && newCusTable[l][1].equals("P")) {
//                        cnt++;
//                        System.out.println("hello");
//                    }
                    if (l > 0) {
                        if (newCusTable[l - 1][m].equals("P")) {
                            cnt++;
                            sum++;
                        } else {
                            cnt += 0;
                        }
                    }
                    if (l < newCusTable.length - 1) {
                        if (newCusTable[l + 1][m].equals("P")) {
                            cnt++;sum++;
                        } else {
                            cnt += 0;
                        }
                    }
                    if (m > 0) {
                        if (newCusTable[l][m - 1].equals("P")) {
                            cnt++;sum++;
                        } else {
                            cnt += 0;
                        }
                    }
                    if (m < newCusTable[l].length - 1) {
                        if (newCusTable[l][m + 1].equals("P")) {
                            cnt++;sum++;
                        } else {
                            cnt += 0;
                        }
                    }
                    System.out.print(cnt);
                }
                System.out.println();
                System.out.println(cnt);
                System.out.println();

            }
            System.out.println();
            if (sum >= 2) {
                answer[ans++] = 0;
            } else {
                answer[ans++] = 1;
            }

        }
        for (int q = 0; q < 5; q++) {
            System.out.println(answer[q]);
        }

        return answer;
    }
}
