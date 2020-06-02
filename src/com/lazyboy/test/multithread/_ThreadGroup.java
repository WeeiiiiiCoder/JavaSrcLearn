package com.lazyboy.test.multithread;

/**
 * 线程组和线程优先级
 *
 * @auther: zhouwei
 * @date: 2020/6/1 15:42
 */
public class _ThreadGroup {

    public static void main(String[] args) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        String threadGroupName = threadGroup.getName();
        System.out.println("当前线程组的名字 = " + threadGroupName);
        //=============================
        //线程必须存在某个线程组中，Thread不能独立于ThreadGroup存在。执行main()方法线程的名字是main，
        //如果在new Thread时没有显式指定，那么默认将父线程（当前执行new Thread的线程）线程组设置为自己的线程组。
        //=============================
        Thread testThread = new Thread(() -> {
            System.out.println("testThread当前线程组名字=" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字=" + Thread.currentThread().getName());
        });

        testThread.start();
        System.out.println("执行main方法线程名字=" + Thread.currentThread().getName());

    }
}