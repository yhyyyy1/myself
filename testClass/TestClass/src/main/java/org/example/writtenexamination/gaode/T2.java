package org.example.writtenexamination.gaode;

import java.util.Scanner;

public class T2 {
    public static int[][] array;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] inputs = input.substring(2, input.length() - 2).split("],\\[");

        array = new int[inputs.length][inputs[0].length() / 2 + 1];
        for (int i = 0; i < inputs.length; i++) {
            String[] temp = inputs[i].split(",");
            for (int j = 0; j < temp.length; j++) {
                array[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int ans = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 1) {
                    ans++;
                    array[i][j] = 0;
                    checkArray(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    private static void checkArray(int i, int j) {
        if (i != 0 && array[i - 1][j] == 1) {
            array[i - 1][j] = 0;
            checkArray(i - 1, j);
        }

        if (j != 0 && array[i][j - 1] == 1) {
            array[i][j - 1] = 0;
            checkArray(i, j - 1);
        }

        if (i != array.length - 1 && array[i + 1][j] == 1) {
            array[i + 1][j] = 0;
            checkArray(i + 1, j);
        }

        if (j != array[0].length - 1 && array[i][j + 1] == 1) {
            array[i][j + 1] = 0;
            checkArray(i, j + 1);
        }
    }
}
