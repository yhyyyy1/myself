package org.example.writtenexamination.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] timeA = new int[n];
        int[] timeB = new int[n];
        int minA = Integer.MAX_VALUE;
        int indexA = 0;
        for (int i = 0; i < n; i++) {
            timeA[i] = in.nextInt();
            if (timeA[i] < minA) {
                minA = timeA[i];
                indexA = i;
            }
        }

        int minB = Integer.MAX_VALUE;
        int indexB = 0;
        for (int i = 0; i < n; i++) {
            timeB[i] = in.nextInt();

            if (timeB[i] < minB) {
                minB = timeB[i];
                indexB = i;
            }
        }

        if (indexA != indexB) {
            System.out.println(Math.max(minA, minB));
        } else {
            // get 第二大
            Arrays.sort(timeA);
            Arrays.sort(timeB);
            int minAAndB = Math.max(minA, timeB[1]);
            int minBAndA = Math.max(timeA[1], minB);

            int minMix = Math.min(minAAndB, minBAndA);
            System.out.println(Math.min(minMix, minA + minB));
        }

    }
}
