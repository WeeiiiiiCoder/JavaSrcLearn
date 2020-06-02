package com.lazyboy.test.multithread;

/**
 * @auther: zhouwei
 * @date: 2020/6/1 17:04
 */
public class _Thread_State {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{});
        thread.start();
        thread.start();
    }

    private static synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}