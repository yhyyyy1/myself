package org.example.writtenexamination.jd;

import java.util.Scanner;

/**
 * A
 */
public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] table = new int[n + 1][m + 1];

        int k = in.nextInt();
        in.nextLine();

        int hang;
        int lie;
        boolean have;


        for (int i = 0; i < k; i++) {
            String[] op = in.nextLine().split(" ");
            have = false;
            switch (op[0]) {
                case "c":
                    table[Integer.parseInt(op[1])][Integer.parseInt(op[2])] = 1;
                    break;
                case "l":
                    hang = Integer.parseInt(op[1]);
                    for (int j = Integer.parseInt(op[2]) - 1; j > 0; j--) {
                        if (table[hang][j] == 0) {
                            System.out.println(hang + " " + j);
                            have = true;
                            break;
                        }
                    }
                    if (!have) {
                        System.out.println(-1);
                    }
                    break;
                case "r":
                    hang = Integer.parseInt(op[1]);
                    for (int j = Integer.parseInt(op[2]) + 1; j <= m; j++) {
                        if (table[hang][j] == 0) {
                            System.out.println(hang + " " + j);
                            have = true;
                            break;
                        }
                    }
                    if (!have) {
                        System.out.println(-1);
                    }
                    break;
                case "u":
                    lie = Integer.parseInt(op[2]);
                    for (int j = Integer.parseInt(op[1]) - 1; j > 0; j--) {
                        if (table[j][lie] == 0) {
                            System.out.println(j + " " + lie);
                            have = true;
                            break;
                        }
                    }
                    if (!have) {
                        System.out.println(-1);
                    }
                    break;
                case "d":
                    lie = Integer.parseInt(op[2]);
                    for (int j = Integer.parseInt(op[1]) + 1; j <= n; j++) {
                        if (table[j][lie] == 0) {
                            System.out.println(j + " " + lie);
                            have = true;
                            break;
                        }
                    }
                    if (!have) {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}
