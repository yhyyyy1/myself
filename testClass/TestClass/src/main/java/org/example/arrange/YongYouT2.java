package org.example.arrange;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class YongYouT2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] grid = new int[n][n];

        // 因为要使用队列解题，队列中的元素设置为 位置 + 距离 1 的距离——（x,y,distance）
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
                if (grid[i][j] == 1) {
                    // 顺便找到初始为1的节点，放入队列中
                    queue.add(new int[]{i, j, 0}); // 初始化有值的数组 写法每次都忘。。。
                }
            }
        }

        // 根据题目描述——如果整个公司都是有电力设施的区域或者没有电力设施的区域，请返回-1。
        // 再进行一次判断

        if (queue.isEmpty() || queue.size() == n * n) {
            System.out.println(-1);
            return;
        }

        // 接下来就是层序遍历的流程了
        int maxDistance = 0;

        // 定义出四个方向
        // 方便后序的判断
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};


        while (!queue.isEmpty()) {
            // 遍历queue中的元素
            int[] currentNode = queue.poll();
            int x = currentNode[0];
            int y = currentNode[1];
            int distance = currentNode[2];

            // 每次都要更新最大距离
            maxDistance = Math.max(maxDistance, distance);

            // 接着向四个方向拓展
            for (int[] direction : directions) {
                int targetX = x + direction[0];
                int targetY = y + direction[1];

                // 如果新位置超出网格边界或已经被占据，则跳过
                if (targetX >= n || targetX < 0 || targetY >= n || targetY < 0 || grid[targetX][targetY] == 1) {
                    continue;
                }

                grid[targetX][targetY] = 1;
                queue.add(new int[]{targetX, targetY, distance + 1});
            }
        }

        System.out.println(maxDistance);
    }
}
