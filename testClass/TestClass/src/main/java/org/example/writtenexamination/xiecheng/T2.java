package org.example.writtenexamination.xiecheng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        char[] tempInput = in.nextLine().toCharArray();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (tempInput[i] == '0') count++;
        }
        for (int num = 2; num < n; num += 2) {
            for(int left = 0; left < n - num; left++) {
                int right = left + num;
                int times = 0;
                for (int i = right; i >= left; i--) {
                    if (times % 2 == 0 && tempInput[i] == '0' || times % 2 == 1 && tempInput[i] == '1') {
                        times++;
                    }
                }
                if (times % 2 == 1) count++;
            }
        }
        System.out.println(count);
    }
}

