package org.example.writtenexamination.mihayo;

import java.util.Scanner;

/**
 * 不知为什么就过了，感觉有很多没处理的东西
 */
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();


        int max = 0;
        int ans = 0;
        for (int i = m; i >= n; i--) {
            int temp = i;
            int tempMax = 0;
            while (temp > 0) {
                if (temp % 10 == 4 || temp % 10 == 6) {
                    tempMax++;
                }
                temp = temp / 10;
            }
            if (max < tempMax) {
                ans = i;
                max = tempMax;
            }
        }

        System.out.println(ans);

    }
}
