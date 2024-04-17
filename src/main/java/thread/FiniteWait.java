package thread;

/**
 * @author : sz
 * @Description :
 * @date : 2022-11-30 13:26
 **/
public class FiniteWait {

    public static void main(String[] args) throws InterruptedException {
        long start = 0l;
        long end = 0l;
        Object o = new Object();
        synchronized (o){

            System.out.println("等待3秒为唤醒超时");
            try {
                start = System.currentTimeMillis();
                o.wait(3000l);
                end = System.currentTimeMillis();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("结束耗时：" + (end - start) + "ms.");
            }

            System.out.println("我出来了");


        }
    }
}
