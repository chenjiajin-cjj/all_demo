package chenjiajin.concurrency_coding.threads.pools;

import java.util.concurrent.*;

/**
 * 手写线程池
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        int max = (int) (Runtime.getRuntime().availableProcessors() / (1 - 0.9));

        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(max - 5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 1; i <= 100; i++) {
                final int temp = i;
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + temp);
                });
                Thread.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }

}
