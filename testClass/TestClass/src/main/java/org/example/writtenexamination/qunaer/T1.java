package org.example.writtenexamination.qunaer;

import java.util.*;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();

        for (int num : array) {
            output.add(num);
        }
        backtrack(n, output, res, 0);

        int index = 0;
        List<Integer> temp = res.get(index);
        StringBuilder min = new StringBuilder();
        for (Integer integer : temp) {
            min.append(integer);
        }

        List<Integer> ans = temp;
        while (index < res.size()) {
            temp = res.get(index++);
            StringBuilder tempString = new StringBuilder();
            for (Integer integer : temp) {
                tempString.append(integer);
            }

            if (tempString.toString().compareTo(min.toString()) < 0) {
                min = tempString;
                ans = temp;
            }
        }

//        System.out.println(min);

        for (Integer integer : ans) {
            System.out.print(integer + " ");
        }
    }


    private static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            // 所有数字都填好了
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, first, i);
        }
    }
}
