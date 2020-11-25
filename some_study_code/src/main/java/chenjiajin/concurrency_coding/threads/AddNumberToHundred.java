package chenjiajin.concurrency_coding.threads;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AddNumberToHundred {


    public static void main(String[] args) {
        po a = new po();
        new Thread(() -> {
            while (true) {
                try {
                    a.jishu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            while (true) {
                try {
                    a.oushu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }

}

class po {

    private volatile static int num;
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public void jishu() throws Exception {
        try {
            lock.lock();
            //如果是偶数就阻塞着
            if (num % 2 == 0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + ":" + num);
            if (num == 100) {
                System.exit(0);
            }
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void oushu() throws Exception {
        try {
            lock.lock();
            //如果是奇数就阻塞
            if (num % 2 == 1) {
                condition.await();
            }
            if (num == 100) {
                System.exit(0);
            }
            num++;
            System.out.println(Thread.currentThread().getName() + ":" + num);

            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}