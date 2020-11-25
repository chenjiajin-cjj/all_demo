package chenjiajin.concurrency_coding.locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 手写一个自旋锁
 * <p>
 * 是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程
 * 上下文切换的消耗，缺点是循环会消费CPU
 */
public class CAStest {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        System.out.println(Thread.currentThread().getName() + ":来拉屎啦");
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)) {
            System.out.println(Thread.currentThread().getName() + ":里面谁啊，快点啊，老子要拉出来了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + ":拉完开门啦");
    }

    public static void main(String[] args) {
        CAStest caStest = new CAStest();
        new Thread(() -> {
            caStest.lock();
            caStest.unLock();
        }, "甲").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            caStest.lock();
            caStest.unLock();
        }, "乙").start();
    }
}
