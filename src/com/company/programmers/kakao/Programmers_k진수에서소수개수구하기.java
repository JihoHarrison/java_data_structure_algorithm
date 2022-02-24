package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/24
 * Time: 9:01 오후
 * desc: 에라토스테네스의 체를 다시 공부할 수 있었던 기회였고, 10진수를 k진수로 변환하는 방법에 대해서 공부할 수 있었던 문제. 그리 어렵진 않은 것 같음.
 */
public class Programmers_k진수에서소수개수구하기 {

    public static void main(String[] args) {

        solution(110011, 10);

    }

    private static int solution(int n, int k) {
        int answer = 0;

        String num = toKnum(n, k);

        String[] numList = num.split("0");

        for (String str : numList) {
            // 110011 의 경우 가운데 00은 아무것도 반환하지 못함. 빈칸 나옴. 해당 경우는 바로 continue
            System.out.println(str);
            if (str.equals("")) continue;
            if (isPrime(Long.parseLong(str))) {
                answer++;
            }
        }

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

    private static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}