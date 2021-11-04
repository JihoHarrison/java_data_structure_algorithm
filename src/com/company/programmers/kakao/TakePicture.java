package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/04
 * Time: 9:42 오전
 */
//public class TakePicture {
//   public static int totalCnt = 0;
//    private static String[] kakaoExample = {"A", "C", "F", "J", "M", "N", "R", "T"};
//    private static String[] data1 = {"N~F=0", "R~T>2"};
//
//    String[] data2 = {"M~C<2", "C~M>1"};
//    String[] data3 = {"A~B<2", "B~A>1"};
//
//    public static void main(String[] args) {
//
//        //String[] data1 = {"N~F=0", "R~T>2"};
//        String[] data2 = {"M~C<2", "C~M>1"};
//        String[] data3 = {"A~B<2", "B~A>1"};
//
//        solution(2, data1);
//    }
//
//    public static int solution(int n, String[] data) {
//       boolean[] visited = new boolean[kakaoExample.length];
//
//        dfs("", data, visited);
//        int answer = totalCnt;
//        System.out.println(answer);
//        return answer;
//    }
//
//    public static void dfs(String searchExample, String[] datas, boolean[] visited) {
//        if (searchExample.length() == 7) {
//            if (checkFriends(searchExample, datas)) {
//                totalCnt++;
//                System.out.println(totalCnt);
//            }
//            return;
//        }
//
//        for (int i = 0; i < 8; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                searchExample = searchExample + kakaoExample[i];
//                dfs(searchExample, datas, visited);
//                visited[i] = false;
//            }
//        }
//    }
//
//    public static boolean checkFriends(String searchExample, String[] datas) {
//        for (String data : datas) {
//            int sugPos = searchExample.indexOf(data.charAt(0));
//            int othPos = searchExample.indexOf(data.charAt(2));
//           // int resultPos = Math.abs(sugPos - othPos) + 1;
//            char op = data.charAt(3); // 수식
//            int index = data.charAt(4) -'0'; // 간격
//            if (op == '=') {
//                if (!(Math.abs(sugPos - othPos) == index+1)) return false; //둘 포지션 차이를 구하기 위해선 index+1 을 해야함에 주의
//            } else if (op == '>') {
//                if (!(Math.abs(sugPos - othPos) > index+1)) return false;
//            } else if (op == '<') {
//                if (!(Math.abs(sugPos - othPos) < index+1)) return false;
//            }
//        }
//        return true;
//    }
//}

public class TakePicture {
    public static int totalCnt = 0;
    public static String[] kakaoExample = {"A", "C", "F", "J", "M", "N", "R", "T"};


    public static void main(String[] args) {
        String[] data1 = {"N~F=0", "R~T>2"};
        String[] data2 = {"M~C<2", "C~M>1"};
        String[] data3 = {"A~B<2", "B~A>1"};

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
        if (names.length() == kakaoExample.length - 1) {
            if (check(names, datas)) {
                totalCnt++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                String name = names + kakaoExample[i];
                dfs(name, isVisited, datas);
                isVisited[i] = false;
            }
        }
    }

    public static boolean check(String searchExample, String[] datas) {
        for (int i = 0; i < datas.length; i++) {
            int position1 = searchExample.indexOf(datas[i].substring(0, 1));
            int position2 = searchExample.indexOf(datas[i].substring(2, 3));
            char op = datas[i].charAt(3);
            int index = datas[i].charAt(4) - '0';
            int resultPos = Math.abs(position1 - position2);
            if (op == '=') {
                if (!(resultPos == index + 1)) return false;
            } else if (op == '>') {
                if (!(resultPos > index + 1)) return false;
            } else if (op == '<') {
                if (!(resultPos < index + 1)) return false;
            }
        }
        return true;
    }
}