package com.lazyboy.test.multithread;

import java.util.concurrent.*;

/**
 * @auther: zhouwei
 * @date: 2020/6/1 11:05
 */
public class Callable_Future_FutureTask {

     static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(5000);
            return 2;
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
            ExecutorService executorService = Executors.newCachedThreadPool();
            MyCallable myCallable = new MyCallable();
            Future<Integer> future = executorService.submit(myCallable);
            //注意调用get方法会阻塞当前线程，直到得到结果。
            //实际建议使用可以设置超时时间的重载get方法
            boolean cancel = future.cancel(true);
            System.out.println(cancel);
            System.out.println(future.get(6,TimeUnit.SECONDS));
        }
    }



}