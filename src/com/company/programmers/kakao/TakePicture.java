package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/04
 * Time: 9:42 오전
 */
public class TakePicture {
    public static int totalCnt = 0;
    public static String[] kakaoFriendNames = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public static void main(String[] args) {
        String[] data1 = {"N~F=0", "R~T>2"};
        String[] data2 = {"M~C<2", "C~M>1"};

        solution(2, data1);
    }

    public static int solution(int n, String[] data) {
        boolean[] isVisited = new boolean[8];
        dfs("", isVisited, data);
        int answer = totalCnt;
        System.out.println(answer);
        return answer;
    }

    public static void dfs(String names, boolean[] isVisited, String[] datas) {
        if (names.length() == kakaoFriendNames.length) {
            if (check(names, datas)) {
                totalCnt++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                String name = names + kakaoFriendNames[i];
                dfs(name, isVisited, datas);
                isVisited[i] = false;
            }
        }
    }

    public static boolean check(String searchExample, String[] datas) {
        for (int i = 0; i < datas.length; i++) {
            int sugPos = searchExample.indexOf(datas[i].substring(0, 1));
            int othPos = searchExample.indexOf(datas[i].substring(2, 3));
            String op = datas[i].substring(3, 4);
            int index = datas[i].charAt(4) - '0';
            int resultPos = Math.abs(sugPos - othPos);
            if (op.equals("=")) {
                if (!(resultPos == index + 1)) {
                    return false;
                }
            } else if (op.equals(">")) {
                if (!(resultPos > index + 1)) {
                    return false;
                }
            } else if (op.equals("<")) {
                if (!(resultPos < index + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}