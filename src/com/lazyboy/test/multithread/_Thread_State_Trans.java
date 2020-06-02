package com.lazyboy.test.multithread;

/**
 * @auther: zhouwei
 * @date: 2020/6/2 10:48
 */
public class _Thread_State_Trans {

    public static void main(String[] args) throws InterruptedException {
        Thread athread = new Thread(_Thread_State_Trans::testMethod);
        Thread bthread = new Thread(_Thread_State_Trans::testMethod);
        athread.start();
        bthread.start();
        System.out.println("athread.getState() = " + athread.getState());
        System.out.println("bthread.getState() = " + bthread.getState());
        //-----------------------------------------------------
        //main方法中先启动main线程,然后ab线程执行start方法,但是从start方法启动线程后执行run方法还是需要消耗一定时间的
        //所以ab线程都启动后,main线程休眠2s,先执行a线程run方法获取锁对象并休眠2s，main线程休眠结束时a线程休眠结束或者没结束
        //如果此时a线程休眠结束,那么a线程状态就是TERMINATED,b线程可能休眠，状态可能为TIMED_WAITING
        //如果此时a线程未休眠结束,那么a线程状态就是TIMED_WAITING,b线程就是阻塞BLOCKED
        //
        //-----------------------------------------------------
        Thread.sleep(2000L);
        System.out.println("athread.getState() = " + athread.getState());
        System.out.println("bthread.getState() = " + bthread.getState());

    }


    private static synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}