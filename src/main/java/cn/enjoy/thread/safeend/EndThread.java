package cn.enjoy.thread.safeend;

public class EndThread {

    private static class UseThread extends Thread{
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run(){
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()) {
                System.out.println(threadName+" is run! interrput flag is "+isInterrupted());
            }
            System.out.println(threadName + " interrput flag is "+ isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }

}
