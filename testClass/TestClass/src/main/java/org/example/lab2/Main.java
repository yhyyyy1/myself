package org.example.lab2;

public class Main {
    public static int maxProduct(int n) {
        if (n <= 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            //每次存储当前的拆分最大值
            dp[i] = 0;
            for (int j = 1; j < i; j++) {
                //将多次的拆分转化成一次拆分，dp[n]保证对n的拆分是最大的
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int input = 55;
        int output = maxProduct(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output); // Output should be 36
    }
}
