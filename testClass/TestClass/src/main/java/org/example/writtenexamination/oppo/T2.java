package org.example.writtenexamination.oppo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] input = new int[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
        }

        int mex = 0;
        for (int i = 0; i < map.size(); i++) {
            if (map.containsKey(mex)) mex++;
            else break;
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (input[i] > mex) ans[i] = mex;
            else {
                if (map.get(input[i]) > 1) ans[i] = mex;
                else {
                    ans[i] = input[i];
                }
            }
        }

        // 输出
        for(int i = 0;i<n;i++){
            System.out.print(ans[i] + " ");
        }
    }
}
