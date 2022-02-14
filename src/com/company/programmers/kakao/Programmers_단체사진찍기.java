package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/14
 * Time: 11:43 오후
 */
class Programmers_단체사진찍기 {
    static String[] kakaoFriendNames = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static String[] result = new String[8];
    static boolean[] visited = new boolean[8];
    static int answer;

    public static void main(String[] args) {
        String[] data1 = {"N~F=0", "R~T>2"};
        String[] data2 = {"M~C<2", "C~M>1"};
        solution(2, data1);
    }

    public static int solution(int n, String[] data) {
        answer = 0;
        perm(0, data);
        System.out.println(answer);
        return answer;
    }

    static void perm(int cnt, String[] data) {
        if (cnt == 8) {
            String s = "";
            for (int i = 0; i < kakaoFriendNames.length; i++) {
                s += result[i];
            }
            for (int i = 0; i < data.length; i++) {
                int start = s.indexOf(data[i].charAt(0));
                int end = s.indexOf(data[i].charAt(2));

                if (data[i].charAt(3) == '=' && Math.abs(start - end) - 1 != data[i].charAt(4) - '0') {
                    return;
                } else if (data[i].charAt(3) == '<' && Math.abs(start - end) - 1 >= data[i].charAt(4) - '0') {
                    return;
                } else if (data[i].charAt(3) == '>' && Math.abs(start - end) - 1 <= data[i].charAt(4) - '0') {
                    return;
                }
            }
            answer++;
            return;
        }
        for (int i = 0; i < kakaoFriendNames.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[cnt] = kakaoFriendNames[i];
                perm(cnt + 1, data);
                visited[i] = false;
            }
        }
    }
}
