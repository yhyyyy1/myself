package org.example.writtenexamination.xiecheng;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        for (int i = 1; i < k; i++) {
            System.out.print(i + " ");
        }


        for (int i = n; i >= k; i--) {
            System.out.print(i + " ");
        }
    }
}
