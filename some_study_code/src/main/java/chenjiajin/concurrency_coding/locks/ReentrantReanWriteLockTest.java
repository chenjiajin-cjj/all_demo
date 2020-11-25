package chenjiajin.concurrency_coding.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 设计一个可重入的读写锁
 * <p>
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行
 * 但是
 * 如果有一个线程想去写共享资源类，就不应该再有其他线程可以对该线程进行读或写
 * 总结：
 * 读-读能共存
 * 读-写不能共存
 * 写-写不能共存
 * 写操作:原子性+独占，整个过程必须是一个完整的统一体，中间不许被分割，被打断
 */
public class ReentrantReanWriteLockTest {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 1; i <= 5; i++) {
            int temp = i;
            new Thread(() -> {
                cache.put(temp + "", temp + "");
            }, temp + "").start();
        }
        for (int i = 1; i <= 5; i++) {
            int temp = i;
            new Thread(() -> {
                cache.get(temp + "");
            }, temp + "").start();
        }
    }
}

class Cache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object val) {
        try {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t 正在写入:" + key);
            Thread.sleep(300);
            map.put(key, val);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {

        try {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t 正在读取");
            Thread.sleep(300);
            Object object = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }

    }
}