package org.example.writtenexamination.mihayo;

import java.util.Scanner;

/**
 * 题目没说清除。。。不然早结束了
 */
public class T2 {
    private static long maxNum = 0;
    private static int n;
    private static int[] c;
    private static int[] used;

    private static int[][] boss;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        int m = in.nextInt();

        c = new int[m]; // 额外奖励
        used = new int[m]; // 第i个英雄用例used[i]次了
        boss = new int[n][6]; // 第i个关卡的信息，0-2是奖励，3-5是使用哪个英雄

        for (int i = 0; i < m; i++) {
            c[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                boss[i][j] = in.nextInt();
            }
        }

        challenge(0, 0);
        System.out.println(maxNum);
    }

    private static void challenge(int times, long nowNum) {
        for (int i = 0; i < 3; i++) {
            // 遍历本次的情况， times对应的是第几关
            long temp = nowNum;

            temp += boss[times][i];
            if (++used[boss[times][i + 3] - 1] % 3 == 0) {
                temp += c[boss[times][i + 3] - 1];
            }

            if (times == n - 1) {
                // 本次是最后一次，不用再循环了
                maxNum = Math.max(maxNum, temp);
            } else {
                // 非最后一次，需要循环
                challenge(times + 1, temp);
            }
            used[boss[times][i + 3] - 1]--;
        }
    }
}
