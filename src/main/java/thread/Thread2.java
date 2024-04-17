package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author : sz
 * @Description :
 * @date : 2022-07-21 14:19
 **/
public class Thread2 {

    public static void main(String[] args) throws InterruptedException {

        Thread2 dfs = new Thread2();
        Thread t1 = new Thread(()->{
            Thread2 ab1 = new Thread2();
            try {
                ab1.chunkLock("wo");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            Thread2 ab2 = new Thread2();
            try {
                ab2.chunkLock("ta");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        System.out.println("11111111");
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("22222222");
    }

    public synchronized void tt() throws InterruptedException {
        System.out.println("ssssssssss");
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });
        synchronized(thread){

            System.out.println(thread.getState());
            thread.start();
            thread.wait();
            System.out.println(thread.getState());
            thread.notify();
            System.out.println(thread.getState());

        }

    }

    public synchronized void aa(String name) throws InterruptedException {

        for (int i = 0; i < 3; i++) {

            System.out.println(name + i);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public synchronized static void bb(String name) throws InterruptedException {

        for (int i = 0; i < 3; i++) {

            System.out.println(name + i);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void chunkLock(String name) throws InterruptedException {
        System.out.println("thread:"+name);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("thread:"+name);
        synchronized (this){
            for (int i = 0; i < 3; i++) {

                System.out.println(name + i);
                TimeUnit.SECONDS.sleep(1);
            }
        }
        System.out.println("thread:"+name);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("thread:"+name);
    }

}
