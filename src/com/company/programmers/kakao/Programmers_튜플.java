package com.company.programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/21
 * Time: 8:00 오후
 * desc: TreeSet, HashMap 둘 중에 고민했지만 결국 ArrayList contains로 추가해줘야 순서가 맞음.
 */
public class Programmers_튜플 {

    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        solution(s);
    }

    public static int[] solution(String s) {
        ArrayList<Integer> answerList = new ArrayList<>();

        StringBuilder sb = new StringBuilder(s);
        sb = sb.deleteCharAt(0);
        sb = sb.deleteCharAt(sb.length() - 1);
        sb = sb.deleteCharAt(0);
        sb = sb.deleteCharAt(sb.length() - 1);

        String divide = sb.toString();

        String[] list = divide.split("},\\{");

        Arrays.sort(list, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        for (String j : list) {
            String[] str = j.split(",");

            for (int i = 0; i < str.length; i++) {
                int temp = Integer.parseInt(str[i]);
                if (!answerList.contains(temp)) {
                    answerList.add(temp);
                }
            }
        }

        int[] answer = new int[answerList.size()];
        int count = 0;

        for (int k : answerList) {
            answer[count++] = k;
        }

        for (int p : answer) {
            System.out.print(p + " ");
        }

        return answer;
    }
}