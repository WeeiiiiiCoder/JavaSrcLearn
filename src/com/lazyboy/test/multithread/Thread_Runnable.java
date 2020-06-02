package com.lazyboy.test.multithread;

import java.util.logging.Logger;

/**
 * @auther: zhouwei
 * @date: 2020/5/29 16:20
 */
public class Thread_Runnable {
    private static Logger log = Logger.getLogger("Thread_Runnable");
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread is " + Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
        log.info(String.format("%d%%", 30));
        MyThread myThread = new MyThread();
        myThread.run();
        myThread.start();

        new Thread(() -> System.out.println("Java 8 匿名内部类")).start();
    }
}