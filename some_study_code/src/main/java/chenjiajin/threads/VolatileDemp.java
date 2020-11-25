package chenjiajin.threads;

public class VolatileDemp {

    /**
     * 有点东西这个字符串永远不会被打印出来，因为flag被修改后放到主内存，但是在这个线程并没有去主线程获取
     * 导致flag在这里永远是flase
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Aobing a = new Aobing();
        a.start();
        for(;;){
            if(a.isFlag()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("有点东西");
            }
        }
    }

}

class Aobing extends Thread{
    private boolean flag = false;
    public boolean isFlag(){
        return flag;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag="+flag);
    }

}