package cn.enjoy.thread.safeend;

public class EndRunnable {

    /*实现Runnable接口*/
    private static class UseRun implements Runnable{
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!Thread.currentThread().isInterrupted()) {//如果是继承Thread，那么 isInterrupted() 直接调用，不用加 Thread.currentThread().
                System.out.println(threadName+" is run!");
            }
            System.out.println(threadName + " interrput flag is "+ Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseRun useRun = new UseRun();
        Thread thread = new Thread(useRun,"useRun");
        thread.start();
        Thread.sleep(20);
        thread.interrupt();
    }
}
