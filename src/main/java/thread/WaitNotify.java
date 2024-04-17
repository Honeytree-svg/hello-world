package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : sz
 * @Description :
 * @date : 2022-07-22 10:36
 **/
public class WaitNotify {

    public static void main(String[] args) throws InterruptedException {
        MyTTTT my = new MyTTTT(0,"wo");
        Thread t1 = new Thread(()->{

            System.out.println("创建线程");
            synchronized (my){

                System.out.println("进入同步代码块----");
                try {
                    System.out.println("my对象上锁");
                    my.wait();
                    System.out.println(my.getSum());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("");
            }
        });
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        my.setSum(my.getSum()+1);
        System.out.println(my.getSum());
        synchronized (my){
            System.out.println("my对象开锁");
            my.notify();
        }

    }
}
