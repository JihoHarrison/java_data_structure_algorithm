package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/26
 * Time: 10:28 오후
 * desc: 아주 옛날에 풀어봤던 문제를 다시 풀어봤다. 테스트케이스 14번에서 걸렸는데 조건 하나를 추가해줘야했다.
 */
public class Programmers_로또최고순위와최저순위 {

    public static void main(String[] args) {

//        int[] lottos = {44,1,0,0,31,25};
//        int[] win_nums = {31, 10, 45, 1, 6, 19};
//        int[] lottos = {45, 4, 35, 20, 3, 9};
//        int[] win_nums = {20, 9, 3, 45, 4, 35};
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};

        for (int i : solution(lottos, win_nums)) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int hitCount = 0;
        int zeroCount = 0;
        int total = 0;

        int[] prize = {6, 5, 4, 3, 2, 1};

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) zeroCount++;
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) hitCount++;
            }
        }

        total = hitCount + zeroCount;
        int minCount = total - zeroCount;
        if (total > 6) {
            total = 6;
        }

        if (minCount <= 0) {
            minCount = 1;
        }

        /** TestCase 14번에서 걸린 부분. 0이 하나도 없고 맞춘 번호도 하나도 없을 때 **/
        if (hitCount == 0 && zeroCount == 0) {
            total = 1;
            minCount = 1;
        }

        answer[0] = prize[total - 1];
        answer[1] = prize[minCount - 1];

        return answer;
    }
}