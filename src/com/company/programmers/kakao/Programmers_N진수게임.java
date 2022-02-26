package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/26
 * Time: 9:01 오후
 * desc: 이전에 k진수에서 소수 개수 구하기 문제에서 사용했던 value를 n진수로 바꿔주는 메서드를 그대로 사용했음. 상대적으로 쉬운 문제.
 */
public class Programmers_N진수게임 {

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int number = 0;

        while (sb.length() < m * t) {
            sb.append(toKnum(number, n));
            number++;
        }

        for (int i = p - 1; i < t * m; i = i + m) {
            sb2.append(sb.charAt(i));
        }

        String answer = sb2.toString();

        return answer;
    }

    private static String toKnum(int value, int n) {

        String result = "";
        if (value == 0) {
            return "0";
        }

        while (value > 0) {

            int share = value / n;
            int remainder = value % n;

            if (remainder > 9) {
                result = (char) (remainder + 55) + result;
            } else {
                result = remainder + result;
            }
            value = share;
        }

        return result;
    }
}
