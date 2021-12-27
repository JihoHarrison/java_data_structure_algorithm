package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/26
 * Time: 6:31 오후
 */
public class Programmers_방금그곡 {
    static int max = 0;

    public static void main(String[] args) {
        String m1 = "ABCDEFG";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        String m3 = "ABC";
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(solution(m1, musicinfos1));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        for (int i = 0; i < m.length(); i++) {
            m = m.replaceAll("A#", "a");
            m = m.replaceAll("C#", "c");
            m = m.replaceAll("D#", "d");
            m = m.replaceAll("F#", "f");
            m = m.replaceAll("G#", "g");
        }

        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");

            for (int j = 0; j < info[3].length(); j++) {
                info[3] = info[3].replaceAll("A#", "a");
                info[3] = info[3].replaceAll("C#", "c");
                info[3] = info[3].replaceAll("D#", "d");
                info[3] = info[3].replaceAll("F#", "f");
                info[3] = info[3].replaceAll("G#", "g");
            }
            String[] starttime = info[0].split(":");
            String[] endtime = info[1].split(":");

            /**
             * 총 걸린 시간을 구해요
             * 시간은 분 단위로 변환, 거기다가 (끝 시간대의 분 - 시작 시간대의 분)을 더하면 총 걸린 시간이 나오지요
             **/
            int hour = Integer.parseInt(endtime[0]) - Integer.parseInt(starttime[0]);
            int min = Integer.parseInt(endtime[1]) - Integer.parseInt(starttime[1]) + (hour * 60);
            //System.out.println(hour + " -> " + min);

            String temp = "";
            for (int k = 0; k < min; k++) {
                temp += info[3].charAt(k % info[3].length());
                /** musicInfo의 멜로디 길이를 초과하는 경우 다음과 같이 판별해요
                 *  0 % 7 = 0
                 *  1 % 7 = 1
                 *  2 % 7 = 2
                 *  3 % 7 = 3
                 *  4 % 7 = 4
                 *  5 % 7 = 5
                 *  6 % 7 = 6
                 *  7 % 7 = 0
                 *  8 % 7 = 1
                 *  9 % 7 = 2
                 *  10 % 7 = 3 .....
                 **/
            }

            /**
             * [문제 조건]
             * 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환해요.
             * 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환해요.
             * 맨 처음은 0 -> 클 경우에만 answer 변경
             **/
            if (temp.contains(m) && max < temp.length()) {
                max = temp.length();
                answer = info[2]; // 노래 제목
            } else {
                answer = "(None)";
            }
            /**
             * else { answer = "(None)"; }
             * 를 해봤지만 0번째 info의 temp 보다 1번째 info의 temp가 더 작고,
             * 주어진 멜로디가 들어가 있지 않는 경우에 걸려서 안돼요.
             **/
        }
//        System.out.println(answer);
        return answer;
    }
}