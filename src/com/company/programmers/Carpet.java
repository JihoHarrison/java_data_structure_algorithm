package com.company.programmers;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/19
 * Time: 4:33 오후
 */
class Carpet {

    public static void main(String[] args) {
        solution(36, 64);
    }

    public static int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int a = 0;
        int b = 0;

        for (int i = 3; i <= total; i++) {
            if (total % i == 0) {
                int col = total / i;
                int row = total / col;
                int yellowRow = row - 2;
                int yellowCol = col - 2;

                if (yellowRow * yellowCol == yellow && col >= row) {
                    a = row;
                    b = col;
                }
            }
        }
        int[] answer = {a, b};

        System.out.println(a + " " + b);

        return answer;
    }

//    public static void carpet(int x) {
//        for (int i = 3; i <= x; i++) {
//            if(x % i == 0) {
//                first = total / i;
//                second = total / first;
//
//                int a = first - 2;
//                int b = second - 2;
//
//                if(a*b == yellow ) {
//
//                }
//            }
//        }
//    }
}