package org.example.writtenexamination.jd;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] lenArray = new int[n];
        for (int i = 0; i < n; i++) {
            lenArray[i] = in.nextInt();
        }


    }

    private static boolean chaRectangle(int x, int y, int z) {
        return (x + y > z) && (x + z > y) && (y + z > x);
    }
}
