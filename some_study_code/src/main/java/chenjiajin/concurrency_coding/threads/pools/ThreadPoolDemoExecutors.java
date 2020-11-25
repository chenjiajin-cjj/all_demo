package chenjiajin.concurrency_coding.threads.pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用自带线程池 但是不推荐使用 这里只做了解
 */
public class ThreadPoolDemoExecutors {

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);//定长的线程池
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();//单线程池
        ExecutorService executorService3 = Executors.newCachedThreadPool();//不定长的线程池，会根据实际派发出不同数量的线程

        try {
            for (int i = 1; i <= 100; i++) {
                final int temp = i;
                executorService3.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + temp);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService3.shutdown();
        }
    }

}
