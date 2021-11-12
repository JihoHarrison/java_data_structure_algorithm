package com.company.programmers;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/10
 * Time: 4:42 오후
 */
class TargetNumber {
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        solution(arr, 3);

    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        visited = new boolean[numbers.length];
        recursive(numbers, 0, target);
        answer = cnt;
        System.out.println(answer);
        return answer;
    }

    public static void recursive(int[] numbers, int idx, int target) {
        //연산 부분
        int total = 0;
        //int a = 0;
        //int b = 0;
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(visited[i] + " ");
            if (visited[i]) {
                //b = numbers[i];
                total += numbers[i];
                System.out.print(numbers[i] + " ");
            } else {
                //a = numbers[i] * (-1);
                total += numbers[i] * (-1);
                System.out.print(numbers[i] * (-1) + " ");
            }
            //System.out.print(a + " ");
            //System.out.print(b + " ");
            //System.out.print(visited[i] + " ");
        }

        //System.out.println();
        //타겟과 맞는지확인
        if (total == target) {
            cnt++;
        }

        //재귀 로직
        for (int i = idx; i < numbers.length; i++) {
            visited[i] = true;
            //System.out.print(i + " -> ");
            System.out.println(i+1 + " got true");
            recursive(numbers, i + 1, target);
            //System.out.println(i + "");
            visited[i] = false;
            System.out.println(i + " got false");
        }
    }
}
