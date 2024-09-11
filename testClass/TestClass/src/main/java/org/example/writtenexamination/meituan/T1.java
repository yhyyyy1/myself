package org.example.writtenexamination.meituan;

import java.util.*;

public class T1 {
    /**
     * 全改成long就对了。。。。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(2/3);
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        int n = in.nextInt();

        long ans = 0L;
        long min = Long.MAX_VALUE;
        long[] ansArray = new long[n];
        long[] firstArray = new long[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            ansArray[i] = Math.abs(c - x) + Math.abs(d - y);
            ans += ansArray[i];
            firstArray[i] = (Math.abs(a - x) + Math.abs(b - y));
        }


        for (int i = 0; i < n; i++) {
            min = Math.min(min, firstArray[i] - ansArray[i]);
        }
        System.out.println(ans * 2 + min);
    }
}
