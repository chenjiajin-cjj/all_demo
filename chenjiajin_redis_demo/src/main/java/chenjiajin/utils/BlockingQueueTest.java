package chenjiajin.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

@Component
public class BlockingQueueTest {

    public ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

    public void test() throws Exception {
        while (true) {
            System.out.println(Thread.currentThread().getName() + ":" + arrayBlockingQueue.take());
            Thread.sleep(1000);
        }
    }

}
