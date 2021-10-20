package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/10/18
 * Time: 12:17 오후
 */
public class Covid19 {

    public static void main(String[] args) {
        
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < places.length; i++) {
            String[][] cusTable = new String[5][5];
            for (int j = 0; j < places[i].length; j++) {
                //System.out.println(places[i].length);
                cusTable[i] = places[i][j].split("");
                for (int k = 0; k < 5; k++) { // 여기가 각 문자열의 요소 반복문
                    // cusTable[i][k];

                }
            }
        }

        return answer;
    }
}
