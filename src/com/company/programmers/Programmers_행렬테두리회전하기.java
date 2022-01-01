package com.company.programmers;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/31
 * Time: 2:13 오전
 */
public class Programmers_행렬테두리회전하기 {

    public static int[][] square;

    public static void main(String[] args) {
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] ans = solution(6, 6, queries);
    
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        square = new int[rows][columns];
        answer = new int[queries.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 문제 조건 -> 이동하기 전의 배열의 상태예요 == ((i-1) x columns + j)
                square[i][j] = i * columns + j + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {

            // 사각형 안의 인덱스는 1부터 시작하기 때문에 0부터 시작하는 형식으로 고쳐줘요
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            // 좌 -> 하 -> 우 -> 상 순서로 회전 할 것이기에
            // 초기값을 기억 해 놓고 마지막 상 부분에서 최종적으로 x1, y1 + 1 부분에 넣어줘야 한번 회전 완성돼요
            int temp = square[x1][y1];

            // 일단 answer는 초기값으로 놓고 더 작은 값이 나올 때 마다 교체해줘요
            answer[i] = temp;

            // 왼쪽
            for (int j = x1; j < x2; j++) {
                square[j][y1] = square[j + 1][y1];
                if (square[j][y1] < answer[i]) answer[i] = square[j][y1];
            }

            // 아래
            for (int j = y1; j < y2; j++) {
                square[x2][j] = square[x2][j + 1];
                if (square[x2][j] < answer[i]) answer[i] = square[x2][j];
            }

            // 오른쪽
            for (int j = x2; j > x1; j--) {
                square[j][y2] = square[j - 1][y2];
                if (square[j][y2] < answer[i]) answer[i] = square[j][y2];
            }

            // 위
            for (int j = y2; j > y1; j--) {
                square[x1][j] = square[x1][j - 1];
                if (square[x1][j] < answer[i]) answer[i] = square[x1][j];
            }

            square[x1][y1 + 1] = temp;

        }

        return answer;
    }
}
