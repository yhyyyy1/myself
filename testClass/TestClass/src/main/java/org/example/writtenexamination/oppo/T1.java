package org.example.writtenexamination.oppo;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();

        int[] input = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
            count += input[i];
        }

        int ans = 0;
        for (int i : input) {
            int temp = count - i * 2;
            if (temp >= 0 && temp <= t) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
