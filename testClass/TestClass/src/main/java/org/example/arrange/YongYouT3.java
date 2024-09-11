package org.example.arrange;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class YongYouT3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int destination = in.nextInt(), initialFuel = in.nextInt();

        // 创建一个大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 表示加油次数
        int times = 0;
        while (in.hasNext()) {
            String[] stationData = in.next().split(",");
            int stationPosition = Integer.parseInt(stationData[0]);
            int fuelAmount = Integer.parseInt(stationData[1]);

            while (initialFuel < stationPosition && !queue.isEmpty()) {
                initialFuel += queue.poll();
                times++;
            }

            if (initialFuel < stationPosition) {
                // 无法再得到油了
                System.out.println(-1);
                return;
            }

            // 如果都不需要，则将这个加油站加入到堆中
            queue.add(fuelAmount);
        }

        // 所有加油站都遍历完了，如果还没有到终点，就从队列中取
        while (initialFuel < destination && !queue.isEmpty()) {
            // 还能取
            initialFuel += queue.poll();
            times++;
        }

        if (initialFuel < destination) {
            // 如果还不行，就直接寄
            System.out.println(-1);
        } else {
            System.out.println(times);
        }
    }
}
