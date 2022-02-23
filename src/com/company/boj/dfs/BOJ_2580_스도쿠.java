package com.company.boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/23
 * Time: 12:08 오전
 * desc: 어렵다.. 백트래킹 연습하려고 만만하게 봤다가 다시 내 위치를 깨닫게 해주고 겸손하게 만들어준 문제..
 */
public class BOJ_2580_스도쿠 {

    private static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; str.hasMoreTokens(); j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        dfs(0, 0);
    }

    private static void dfs(int row, int col) {

        if (col == 9) {
            dfs(row + 1, 0);
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    arr[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            //arr[row][col] = 0;
            return;
        }

        // 빈 칸(arr[row][col])이 아닌 경우도 재귀 호출
        dfs(row, col + 1);
    }

    private static boolean check(int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) {
                return false;
            }
        }

        int box_row = (row / 3) * 3;
        int box_col = (col / 3) * 3;

        for (int i = box_row; i < box_row + 3; i++) {
            for (int j = box_col; j < box_col + 3; j++) {
                if (arr[i][i] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}