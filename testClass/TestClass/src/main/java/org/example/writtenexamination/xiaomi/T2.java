package org.example.writtenexamination.xiaomi;

import java.util.ArrayList;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();

        ArrayList<Integer> seqList = new ArrayList<Integer>(n);
        int count = 0;
        for (int i = 0; i < n; i++) {
            seqList.add(in.nextInt());
            count += seqList.get(i);
        }

        if (n == 1) {
            if (seqList.get(0) == x) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
            return;
        }

        int more = count % x;
        if(more == 0){
            System.out.println(0);
        }
        if (seqList.contains(more)) {
            System.out.println(1);
            return;
        }

        int maxTimes = x - more;
        for (int i = 1; i < maxTimes; i++) {
            if (seqList.contains(more + i)) {
                System.out.println(1 + i);
                return;
            }
        }

        System.out.println(maxTimes);
    }
}
