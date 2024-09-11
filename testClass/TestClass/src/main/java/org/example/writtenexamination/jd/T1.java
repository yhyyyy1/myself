package org.example.writtenexamination.jd;

import java.util.Scanner;

/**
 * 秒杀
 */
public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input.charAt(0) == '-' || input.length() <= 2) {
            System.out.println(0);
            return;
        }

        System.out.println(input.substring(0, input.length() - 2));

    }
}
