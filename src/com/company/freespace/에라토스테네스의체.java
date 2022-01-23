package com.company.freespace;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/23
 * Time: 3:23 오후
 * desc: 에라토스테네스의 체 -> 소수 판별하기
 */
public class 에라토스테네스의체 {

    public static int number = 10;
    public static int[] numberArray = new int[number + 1];

    public static void main(String[] args) {

        eratostenes();

    }

    public static void eratostenes() {

        for (int l = 2; l <= number; l++) {
            numberArray[l] = l;
        }

        for (int i = 2; i <= number; i++) {
            if (numberArray[i] == 0) continue;

            for (int j = i * 2; j <= number; j += i) {
                numberArray[j] = 0;
            }
        }

        for (int k = 2; k <= number; k++) {
            if (numberArray[k] != 0) System.out.print(numberArray[k] + " ");
        }
    }
}