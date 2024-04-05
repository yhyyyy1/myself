// This is a mutant program.
// Author : ysma

package org.example.lab3;


public class BackPack
{

    public static  int backPack( int[] weights, int[] values, int capacity )
    {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w < 0) {
                    dp[i][w] = 0;
                } else {
                    if (weights[i - 1] <= w) {
                        dp[i][w] = Math.max( values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w] );
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }
        }
        return dp[n][capacity];
    }

    public static  void main( java.lang.String[] args )
    {
        int[] weights = { 2, 3, 4, 5 };
        int[] values = { 3, 4, 5, 6 };
        int capacity = 7;
        int maxProfit = BackPack.backPack( weights, values, capacity );
        System.out.println( "背包容量�? " + capacity + " 时，可以获得的最大价值为 " + maxProfit );
    }

}
