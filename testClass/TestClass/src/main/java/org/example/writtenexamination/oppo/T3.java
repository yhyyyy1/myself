package org.example.writtenexamination.oppo;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();
        char[] input = in.nextLine().toCharArray();
        int count = 0;
        int numZero = 0;
        for (int i = 0; i < length; i++) {
            if (input[i] == '?') numZero++;
            else count += input[i];
        }
        int need = 3 - count % 3;
        for (int i = need; i < numZero * 9; i += 3) {

        }
    }
}
