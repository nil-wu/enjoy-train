package cn.enjoy.thread.safeend;

public class HasInterrputException {

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
        hasInterrputEx.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName());
            e.printStackTrace();
        }
        hasInterrputEx.interrupt();
    }
}
