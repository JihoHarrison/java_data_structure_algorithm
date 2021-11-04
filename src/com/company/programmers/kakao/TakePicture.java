package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/11/04
 * Time: 9:42 오전
 */
public class TakePicture {

    static String[] kakaoExample = {"B", "A", "C"};
    //static String[] kakaoExample = {"A", "C", "F", "J", "M", "N", "R", "T"};
    //static boolean[] visitedExample = new boolean[kakaoExample.length];
    static String[] searchExample = new String[kakaoExample.length];
    static boolean[] visited = new boolean[kakaoExample.length];
    //static String[] search = new String[kakao.length];
    //static boolean bfsFlag = false;
    static int totalCnt = 0;

    public static void main(String[] args) {

        String[] data1 = {"N~F=0", "R~T>2"};
        String[] data2 = {"M~C<2", "C~M>1"};
        String[] data3 = {"A~B<2", "B~A>1"};

        solution(2, data3);
    }

    public static int solution(int n, String[] data) {

        String[] opArr = {"=", "<", ">"};
        // 연산자
        String op = "";
        int dfsCount = 0;
        for (int i = 0; i < n; i++) {
            // 제안자 분리
            String sug = data[i].substring(0, 1);
            // 연산자 분리
            for (String operator : opArr) {
                if (data[i].substring(3, 4).equals(operator)) {
                    op = operator;
                }
            }
            // 상대방 분리
            String oth = data[i].substring(2, 3);
            // 떨어져있기를 원하는 거리 분리
            int distance = Integer.parseInt(data[i].substring(4));

            if(dfsCount <= 0){
                dfs(sug, oth, distance, 0, op, n);
            }
            dfsCount++;

            //dfs(sug, oth, distance, 0, op, n);

        }

        int answer = totalCnt;
        //System.out.println(answer);
        return answer;
    }

    public static void dfs(String sug, String oth, int distance, int start, String op, int lengthData) {

        int sugPos = 0;
        int othPos = 0;
        int resultPos = 0;

        if (start == kakaoExample.length) {
            int dfsCnt = 0;
            for (int j = 0; j < searchExample.length; j++) {
                System.out.print(searchExample[j]);
                if (sug.equals(searchExample[j])) {
                    sugPos = j;
                }
                if (oth.equals(searchExample[j])) {
                    othPos = j;
                }

                resultPos = Math.abs(sugPos - othPos - 1);

                if(op.equals("=")){
                    if (distance == resultPos) {

                        dfsCnt++;
                       // System.out.println(dfsCnt + " ====");
                    }
                }

                if(op.equals(">")){
                    if (resultPos > distance) {

                        dfsCnt++;
                        //System.out.println(dfsCnt + " >>>>");
                    }
                }
                if(op.equals("<")){
                    if (resultPos < distance) {
                        dfsCnt++;
                        //System.out.println(dfsCnt + " <<<<");
                    }
                }
            }

            System.out.println();
            System.out.println(lengthData + " " + dfsCnt);
//            System.out.println(lengthData == dfsCnt);
            if(lengthData == dfsCnt){
                totalCnt++;
            }
            System.out.println(totalCnt);
           // System.out.println();

        } else {

            for (int i = 0; i < kakaoExample.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    searchExample[start] = kakaoExample[i];
                    dfs(sug, oth, distance, start + 1, op, lengthData);
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean checkFriends() {

    }


}
