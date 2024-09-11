package org.example.juctry;

public class print02100 {
    private int nowNum = 1;
    private static Object lock = new Object(); // 锁

    public static void main(String[] args) {
        print02100 print1 = new print02100();

        Thread oddThread = new Thread(() -> print1.printIt(true));
        Thread evenThread = new Thread(() -> print1.printIt(false));

        oddThread.start();
        evenThread.start();
    }

    private void printIt(boolean isOdd) {
        while (nowNum <= 100) {
            synchronized (lock) {
                while ((isOdd && nowNum % 2 == 0) || (!isOdd && nowNum % 2 == 1)) {
                    // 不是你该打印的时候，等着
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 该你了
                if (nowNum <= 100) {
                    System.out.println("Thread " + (isOdd ? "odd  " : "even ") + nowNum);
                    nowNum++;
                    lock.notify();
                }
            }
        }
    }
}
