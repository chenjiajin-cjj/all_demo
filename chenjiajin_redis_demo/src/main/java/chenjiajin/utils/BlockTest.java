package chenjiajin.utils;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;

@Component
public class BlockTest{

    public static ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(10);

    @PostConstruct
    public void run() {
        System.out.println("加载");
        new Thread(()->{
            while (true){
                try {
                    System.out.println(blockingQueue);
                    System.out.println("这里:"+blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("加载结束");
    }
}
