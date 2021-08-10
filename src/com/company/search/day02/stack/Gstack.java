package com.company.search.day02.stack;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/11
 * Time: 1:35 오전
 */
public class ObjectStack {

    private int num;
    private String str;

    public ObjectStack(int num, String str) {
        this.num = num;
        this.str = str;
    }



    public class Gstack<ObjectStack> {

        private int max;
        private int ptr;
        private ObjectStack[] stk;

        static class EmptyIntStackException extends RuntimeException {
            public EmptyIntStackException() {
            }
        }

        public class OverflowIntStackException extends RuntimeException {
            public OverflowIntStackException() {
            }
        }

        public Gstack(int capacity) {
            ptr = 0;
            max = capacity;
            try {
                // 객체 데이터는 최상위 Object 클래스 타입으로 받고 형변환 하는 형식으로 작성!
                stk = (ObjectStack[]) new Object[max];
            } catch (OutOfMemoryError e) {
                max = 0;
            }
        }

        public int push(){

        }
    }


}
