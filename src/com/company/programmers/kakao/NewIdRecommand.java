package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/12/08
 * Time: 5:34 오후
 */
public class NewIdRecommand {


    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        StringBuilder sb = new StringBuilder(new_id);
        System.out.println(solution(new_id));
    }

    public static String solution(String new_id) {
        String answer = "";
        char[] char_new_id = new_id.toCharArray();
//        StringBuilder sb = new StringBuilder(new_id);
        for (int i = 0; i < char_new_id.length; i++) {
            String str = new_id.toLowerCase();
//            if (!isAlphaNumeric(str.charAt(i))) {
//                System.out.println(str.charAt(i) + " ");
//                    sb.setCharAt(i, '');
//                    System.out.println(sb);
//                    str = sb.toString();
//
//            }
            // 정규 표현식 -> isAlphaNumeric() 메소드로 걸로주는 방법을 고도화 한 방법
            str = str.replaceAll("[^a-z0-9-_.]", "");
            // 정규 표현식 -> . 이 2번 이상 나오면 .으로 대체
            str = str.replaceAll("[.]{2,}", ".");
            // 정규 표현식 -> ^(시작)과 $(끝)을 공백으로 대체
            str = str.replaceAll("^[.]|[.]$", "");
            if (str.length() == 0) {
                str += "a";
            }
            if (str.length() >= 16) {
                str = str.substring(0, 15);
            }

            str = str.replaceAll("[.]$", "");

            while ((str.length() < 3)) {
                str += "a";
            }
            answer = str;

        }

        return answer;
    }

    public static boolean isAlphaNumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || (ch == '-') || (ch == '_') || (ch == '.');
    }


}
