package chenjiajin.concurrency_coding.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t 线程启动");
        Thread.sleep(5000);
        return 1024;
    }
}

public class FutuerTaskDemo {

    public static void main(String[] args) throws Exception {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<>(callableDemo);
        new Thread(futureTask, "AA").start();
        new Thread(futureTask, "BB").start();//由于只new 了一个futureTask 所以这边这个不会生效
        int res = 200;
        int ress = futureTask.get(); //这边会一直阻塞着，直到拿到了返回值
        System.out.println(res + ress);
    }
}
