package com.company.programmers;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/10
 * Time: 4:42 오후
 * description : 백트래킹 쓰는데 조건 안걸리고 리턴도 없는 기괴한 형식.. 재귀에 좀 익숙해지면 다같이 리뷰 해 봅시당..
 */
class TargetNumber {
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 1};

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
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(visited[i] + " ");
            if (visited[i]) {
                total += numbers[i];
            } else {
                total += numbers[i] * (-1);
            }
        }

        System.out.println();
        //타겟과 맞는지확인
        if (total == target) {
            cnt++;
        }

        //재귀 로직
        for (int i = idx; i < numbers.length; i++) {
            visited[i] = true;
            recursive(numbers, i + 1, target);
            visited[i] = false;
        }
    }
}
