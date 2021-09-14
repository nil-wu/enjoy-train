package cn.enjoy.thread.safeend;

public class DaemonThread {

    private static class UseThread extends Thread{

        public  UseThread(String name){
            super(name);
        }

        public void run(){
            String threadName = getName();
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(threadName + " interrput flag is " + isInterrupted());
                    e.printStackTrace();
                    interrupt();
                }
                System.out.println(threadName);
            }
            System.out.println(threadName + " interrput flag is " + isInterrupted());
        }
    }

    public static void main(String[] args)  {
        UseThread hasInterrputEx = new UseThread("HasInterrputEx");
        hasInterrputEx.setDaemon(true);//必须写在 start() 之前
        hasInterrputEx.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName());
            e.printStackTrace();
        }
//        hasInterrputEx.interrupt();
    }
}
