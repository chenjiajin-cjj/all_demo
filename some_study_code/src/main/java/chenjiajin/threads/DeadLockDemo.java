package chenjiajin.threads;

/**
 * 死锁的发生情况
 */
public class DeadLockDemo {

    public String lockA = "lockA";
    public String lockB = "lockB";

    public void lockA(){
        synchronized (lockA){
            System.out.println("方法A获得锁A:"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println("方法A获得锁B:"+Thread.currentThread().getName());
            }
        }

    }
    public void lockB(){
        synchronized (lockB){
            System.out.println("方法B获得锁B:"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockA){
                System.out.println("方法B获得锁A:"+Thread.currentThread().getName());
            }
        }

    }
    public static void main(String[] args) {
        DeadLockDemo deadLockDemo = new DeadLockDemo();

        new Thread(()->{
            deadLockDemo.lockA();
        }).start();

        new Thread(()->{
            deadLockDemo.lockB();
        }).start();

    }
}
