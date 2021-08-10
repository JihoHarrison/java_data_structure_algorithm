package com.company.search;

public class BinarySearchX {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 7, 7, 7, 7, 7, 7, 8, 8, 9, 9};

        binarySearchX(arr, arr.length, 7);
    }

    static int binarySearchX(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;
        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
//                while (pc > 0 && a[pc] == a[pc - 1]) {
//                    pc -= 1;
//                    if(pc == 0){
//                        break;
//                    }
//                }
                for(int i = 0; i < pc - 1; i++){
                    if(a[i] == key){
                        System.out.println(i + "번째에 있습니다.");
                        return pc;
                    }
                }
                System.out.println(pc + "번째에 있습니다.");
                return pc;

            } else if (a[pc] > key) {
                pr = pc - 1;
            } else if (a[pc] < key) {
                pl = pc + 1;
            }
        } while (pl <= pr);

        System.out.println("검색에 실패하였습니다.");
        return -1;
    }
}
