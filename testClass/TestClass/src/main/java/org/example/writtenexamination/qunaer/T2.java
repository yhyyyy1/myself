package org.example.writtenexamination.qunaer;

import java.util.*;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int target = in.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }


        int[] dp = new int[n];
        dp[0] = a[0] * b[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] + a[i] * b[i] >= target) {
                System.out.println(i);
            } else {
                int[] tempA = new int[i];
                int[] tempB = new int[i];
                for (int j = 0; j < i; j++) {
                    tempA[j] = a[j];
                    tempB[j] = b[j];
                }
                Arrays.sort(tempA);
                Arrays.sort(tempB);
                for (int j = 0; j < i; j++) {
                    dp[i] += tempA[j] * tempB[j];
                }

                if (dp[i] >= target) {
                    System.out.println(i);
                }
            }
        }
    }
}
