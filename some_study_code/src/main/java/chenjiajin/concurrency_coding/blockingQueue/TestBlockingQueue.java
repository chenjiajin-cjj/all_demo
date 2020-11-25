package chenjiajin.concurrency_coding.blockingQueue;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试阻塞队列的用法
 */
public class TestBlockingQueue {

    public static void main(String[] args) {
        Data data = new Data(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            try {
                System.out.println("生产者启动");
                data.prod();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "prod").start();

        new Thread(() -> {
            try {
                System.out.println("消费者启动");
                data.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "consumer").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("五秒到，线程即将停止");
        data.Flag = false;
    }
}

class Data {
    public volatile boolean Flag = true;
    public BlockingQueue<String> blockingQueue;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public Data(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println("传进来的阻塞队列类型是" + blockingQueue.getClass().getName());
    }

    public void prod() throws Exception {
        String result = null;
        boolean returnVal;
        while (Flag) {
            result = atomicInteger.incrementAndGet() + "";
            returnVal = blockingQueue.offer(result, 2, TimeUnit.SECONDS);//两秒钟放一次
            if (returnVal) {
                System.out.println(Thread.currentThread().getName() + "\t 插入" + result + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入" + result + "失败");
            }
            Thread.sleep(1000);
        }
        System.out.println("线程停止啦");
    }

    public void consumer() throws Exception {
        String result = null;
        while (Flag) {
            result = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (StringUtils.isEmpty(result)) {
                Flag = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过五秒没有接收到新的数据，线程终止");
                System.out.println();
                return;
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 消费" + result + "成功");
            }
        }
    }

}