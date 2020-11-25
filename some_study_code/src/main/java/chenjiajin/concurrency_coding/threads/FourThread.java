package chenjiajin.concurrency_coding.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现四个线程交替
 * 一个进行加 一个进行减
 */
public class FourThread {

    public static void main(String[] args) {
        Data data = new Data();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    data.inc();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "AA").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    data.deInc();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "BB").start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    data.inc();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "CC").start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    data.deInc();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "DD").start();
        }

    }

}

class Data {
    int num;
    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void inc() throws Exception {

        try {
            lock.lock();
            while (num != 0) { //如果这里不用while 而用if会出现线程不安全的情况 而且是api推荐使用while的
                condition.await();//阻塞 相当于以前的Object.wait;
            }
            num++;
            System.out.println("当前线程：" + Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();//唤醒 相当于以前的Object.notifyAll;
        } finally {
            lock.unlock();
        }

    }

    public void deInc() throws Exception {

        try {
            lock.lock();
            while (num == 0) {
                condition.await();//阻塞 相当于以前的Object.wait;
            }
            num--;
            System.out.println("当前线程：" + Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();//唤醒 相当于以前的Object.notifyAll;
        } finally {
            lock.unlock();
        }

    }

}