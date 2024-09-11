package org.example.juctry;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class ProducerAndConsumer {

    private static final AtomicInteger counter = new AtomicInteger(0);
    private static final int FULL = 10;

    private static Object lock = new Object();

    public static void main(String[] args) {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        new Thread(producerAndConsumer.new Producer()).start();
        new Thread(producerAndConsumer.new Consumer()).start();
        new Thread(producerAndConsumer.new Producer()).start();
        new Thread(producerAndConsumer.new Consumer()).start();
        new Thread(producerAndConsumer.new Producer()).start();
        new Thread(producerAndConsumer.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (counter.get() == FULL) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // 开始生产
                    counter.getAndIncrement();

                    System.out.println("ProducerThread：" + Thread.currentThread().getName() + "生产者生产，目前总共有" + counter.get());

                    lock.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (counter.get() == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // 开始消费
                    counter.getAndDecrement();

                    System.out.println("ConsumerThread：" + Thread.currentThread().getName() + "消费者消费，目前还剩" + counter.get());

                    lock.notifyAll();
                }
            }
        }
    }
}
