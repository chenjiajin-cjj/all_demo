package chenjiajin.concurrency_coding.count_thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * CountDownLatch 做的是减法，只有当count减到为0的时候，await才会放行
 */
public class CountDownLatchTest {

    public static int count = 30;

    public static void main(String[] args) throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            int temp = i;
            new Thread(() -> {
                System.out.println(temp + "进来了");
                countDownLatch.countDown();//做减法
            }).start();
        }

        countDownLatch.await();
        System.out.println("所有人都进来了，开始上课");

    }

}

/**
 * CyclicBarrier做加法，只有当await被调用到了count = 30 次后，才会走runnable里的方法
 */
class CyclicBarrierTest {
    public static int count = 30;

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> {
            System.out.println("开始打扫教室");
        });
        for (int i = 0; i < count; i++) {
            int temp = i;
            new Thread(() -> {
                System.out.println(temp + "出去了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
//        Semaphore semaphore = new Semaphore(3,true); //可以切换true 或 flase 来切换公平非公平

        for (int i = 1; i < 7; i++) {
            int temp = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+",抢到车位");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+",停车三秒后离开车位");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            },temp+"").start();
        }
    }
}