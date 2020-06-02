package com.lazyboy.test.multithread;

/**
 * @auther: zhouwei
 * @date: 2020/6/1 16:03
 */
public class _Thread_Priority {
    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(String.format("线程%s优先级为%d", Thread.currentThread().getName(), Thread.currentThread().getPriority()));
        }
    }

    public static void main(String[] args) {
        //=========================================
        //线程的优先级1~10,通常情况下，高优先级的线程将会比低优先级的线程有更高的几率得到执行，线程的调度策略采用抢占式
        //在优先级相同的情况下，按照“先到先得”的原则。
        //注：但是并不是所有的操作系统都支持10级优先级的划分（比如有些操作系统只支持3级划分：低，中，高），Java只是给操作系统一个优先级的参考值，线程最终在操作系统的优先级是多少还是由操作系统决定。
        //=========================================
        Thread thread1 = new Thread(new Task());
        thread1.setPriority(1);
        thread1.start();
        Thread thread2 = new Thread(new Task());
        thread2.setPriority(8);
        thread2.start();

        //=========================================
        //线程的优先级不能大于其所在线程组的优先级，
        //否则该线程的优先级将会失效，取而代之的是线程组的最大优先级。
        //=========================================
        ThreadGroup tg1 = new ThreadGroup("tg1");
        tg1.setMaxPriority(6);
        Thread t1 = new Thread(tg1, "t1");
        t1.setPriority(8);
        System.out.println("线程组tg1优先级为"+tg1.getMaxPriority());
        System.out.println("线程t1优先级为"+t1.getPriority());



    }
}