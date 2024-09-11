package org.example.juctry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterDemo {

    private static final AtomicInteger counter = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            // 100个任务
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        counter.incrementAndGet();
                    }
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

        System.out.println(counter.get());

    }
}
