package main.java.thread;

import java.util.concurrent.*;

public class Excecutorr {

    //这里默认拒绝策略为AbortPolicy
    private static ExecutorService executor = new ThreadPoolExecutor(10,10,60L, TimeUnit.SECONDS,new ArrayBlockingQueue(10));

    public static void main(String[] args) {

        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
    }
}
