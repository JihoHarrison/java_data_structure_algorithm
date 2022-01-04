package com.company.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/01/04
 * Time: 1:59 오후
 * desc: HashSet 썼다가 시간복잡도에서 막혔던 문제.
 *       이유를 알아보니 100만개 정도의 테스트 케이스를 다룰 때에는 HashMap을 써야한다고..
 */
public class Programmers_전화번호목록 {

    public static HashSet<String> numbers;
    public static HashMap<String, String> numbers2;

    public static void main(String[] args) {
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};
        System.out.println(solution(phone_book3));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        numbers2 = new HashMap<String, String>();

        for (int i = 0; i < phone_book.length; i++) {
            numbers2.put(phone_book[i], " ");
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                String s = phone_book[i].substring(0, j);
                if (numbers2.containsKey(s)) {
                    answer = false;
                }
            }
        }
        return answer;
    }

//    public static boolean solution(String[] phone_book) {
//        boolean answer = true;
//
//        numbers = new HashSet<>(Arrays.asList(phone_book));
//        iterator = numbers.iterator();
//
//        while (iterator.hasNext()) {
//            for (int i = 0; i < phone_book.length; i++) {
//                for (int j = 0; j < phone_book[i].length(); j++) {
//                    String s = phone_book[i].substring(0, j);
//                    if(numbers.contains(s)) {
//                        answer = false;
//                    }
//                }
//                System.out.println();
//            }
//        }
//        return answer;
//    }
}
