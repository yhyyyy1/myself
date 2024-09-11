package org.example.writtenexamination.mihayo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] maps = new int[n][m];
        in.nextLine();

        for (int i = 0; i < n; i++) {
            char[] temp = in.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (temp[j] == '.') {
                    // 。是海洋，命名为0
                    maps[i][j] = 0;
                } else {
                    maps[i][j] = 1;
                }
            }
        }

        int ans = 0;
        // 定义 点燃后的海洋是-1，之后不能点了
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 0) {
                    // 未被发现的海洋
                    int[][] tempMap = fireOcean(maps, n, m, i, j);
                    ans = Math.max(ans, gerMaxMainland(tempMap, n, m));
                }
            }
        }

        System.out.println(ans);
    }

    private static int[][] fireOcean(int[][] maps, int n, int m, int i, int j) {
        int[][] tempMap = new int[n][m];
        for (int index = 0; index < maps.length; index++) {
            tempMap[index] = maps[index].clone();
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        Deque<int[]> queue = new ArrayDeque<int[]>();

        maps[i][j] = -1; // 公用的变为已遍历
        tempMap[i][j] = 1; //临时的变为陆地

        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] init = queue.poll();
            int x = init[0];
            int y = init[1];

            for (int[] direction : directions) {
                int targetX = x + direction[0];
                int targetY = y + direction[1];

                if (targetX >= n || targetY >= m || targetX < 0 || targetY < 0 || maps[targetX][targetY] == -1 || maps[targetX][targetY] == 1) {
                    // 遍历过了就直接跳过
                    continue;
                }
                if (tempMap[targetX][targetY] == 0) {
                    maps[targetX][targetY] = -1; // 公用的变为已遍历
                    tempMap[targetX][targetY] = 1; //临时的变为陆地
                }

                queue.add(new int[]{targetX, targetY});
            }
        }
        return tempMap;
    }

    private static int gerMaxMainland(int[][] input, int n, int m) {
        int[][] tempMap = new int[n][m];
        for (int i = 0; i < input.length; i++) {
            tempMap[i] = input[i].clone();
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> queue = new ArrayDeque<int[]>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (tempMap[i][j] == 1) {
                    int tempMax = 0;
                    queue.add(new int[]{i, j});

                    tempMap[i][j] = -1; //临时的变为陆地

                    while (!queue.isEmpty()) {
                        int[] init = queue.poll();
                        int x = init[0];
                        int y = init[1];

                        for (int[] direction : directions) {
                            int targetX = x + direction[0];
                            int targetY = y + direction[1];

                            if (targetX >= n || targetY >= m || targetX < 0 || targetY < 0 || tempMap[targetX][targetY] == -1 || tempMap[targetX][targetY] == 0) {
                                // 遍历过了就直接跳过
                                continue;
                            }
                            if (tempMap[targetX][targetY] == 1) {
                                tempMap[targetX][targetY] = -1; //临时的变为陆地
                                queue.add(new int[]{targetX, targetY});
                                tempMax++;
                            }
                        }
                    }

                    max = Math.max(max, tempMax);
                }
            }
        }
        return max;
    }
}
