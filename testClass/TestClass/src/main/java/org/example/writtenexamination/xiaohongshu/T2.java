package org.example.writtenexamination.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        Arrays.sort(array);
        int[] arrayTarget = new int[n];
        int i = 0;
        int j = n - 1;
        while (j >= 0) {
            if (i == n - 1 - i) {
                arrayTarget[i] = array[j--];
                break;
            }
            arrayTarget[i] = array[j--];
            arrayTarget[n - 1 - i] = array[j--];
            i++;
        }

        // 得到目标数组了
        int total = 0;
        for (int gap = 0; gap <= n; gap++) {
            if (n > gap * 2) {
                // 存在
                for (j = 0; j < gap; j++) {
                    total += arrayTarget[j] * (j + 1);
                    total += arrayTarget[n - 1 - j] * (j + 1);
                }

                for (j = gap; j <= n - 1 - gap; j++) {
                    total += arrayTarget[j] * (gap + 1);
                }

            } else {
                for (i = 0; i < n - gap; i++) {
                    for (j = 0; j <= gap; j++) {
                        total += arrayTarget[i + j];
                    }
                }
            }
        }
        System.out.println(total);
    }
}
