package org.example.writtenexamination.meituan;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class T2 {
    private static final int MOD = 1000000007;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] input = new long[3];
        for (int i = 0; i < input.length; i++) {
            input[i] = in.nextLong();
        }
        long k = in.nextLong();

        // 一般来说，对于最小的值+1更为合适
        Arrays.sort(input);
        long gap1 = (input[1] - input[0]);
        long gap2 = (input[2] - input[1]);
        if (gap1 >= k) {
            // g1自己可以全覆盖
            input[0] += k;
        }

        if (gap1 < k && gap1 + gap2 * 2 >= k) {
            // g1 和 g2 可以全覆盖
            k -= gap1;
            input[0] += (gap1 + k / 2);
            input[1] += k / 2;

            if (k % 2 != 0) {
                // 奇数，+1
                input[1]++;
            }
        }

        if (gap1 + gap2 * 2 < k) {
            // 三者均摊
            k -= (gap1 + gap2 * 2);
            input[0] += (gap1 + gap2 + k / 3);
            input[1] += (gap2 + k / 3);
            input[2] += k / 3;
            if (k % 3 >= 1) {
                input[2]++;
            }

            if (k % 3 == 2) {
                input[1]++;
            }
        }


        input[0] %= MOD;
        input[1] %= MOD;
        input[2] %= MOD;

        System.out.println((input[0] * input[1]) % MOD * input[2] % MOD);
    }
}
