package cn.enjoy.thread.syn;

import cn.enjoy.thread.tools.SleepTools;

public class SynClzAndInst {

    /*使用类锁的线程*/
    private static class SynClass extends Thread{
        public void run(){
            System.out.println("TestClass is running...");
            synClass();
        }
    }
    /*使用对象锁的线程*/
    private static class InstanceSyn implements Runnable{
        private SynClzAndInst synClzAndInst;

        public InstanceSyn(SynClzAndInst synClzAndInst) {
            this.synClzAndInst = synClzAndInst;
        }

        @Override
        public void run() {
            System.out.println("TestInstance is running..." + synClzAndInst);
            synClzAndInst.instance();
        }
    }

    /*使用对象锁的线程*/
    private static class Instance2Syn implements Runnable{
        private SynClzAndInst synClzAndInst;

        public Instance2Syn(SynClzAndInst synClzAndInst) {
            this.synClzAndInst = synClzAndInst;
        }

        @Override
        public void run() {
            System.out.println("TestInstance2 is running..." + synClzAndInst);
            synClzAndInst.instance2();
        }
    }

    /*对象锁*/
    private synchronized void instance(){
        SleepTools.second(1);
        System.out.println("synInstance is going..." + this.toString());
        SleepTools.second(1);
        System.out.println("synInstance ended " + this.toString());
    }

    /*对象锁*/
    private synchronized void instance2(){
        SleepTools.second(1);
        System.out.println("synInstance2 is going..." + this.toString());
        SleepTools.second(1);
        System.out.println("synInstance2 ended " + this.toString());
    }

    /*类锁*/
    private static synchronized void synClass(){
        SleepTools.second(1);
        System.out.println("synClass is going...");
        SleepTools.second(1);
        System.out.println("synClass ended");
    }

    public static void main(String[] args) {
        SynClzAndInst synClzAndInst = new SynClzAndInst();
        Thread t1 = new Thread(new InstanceSyn(synClzAndInst));

        SynClzAndInst synClzAndInst2 = new SynClzAndInst();
        Thread t2 = new Thread(new Instance2Syn(synClzAndInst2));

        t1.start();
        t2.start();

        SynClass synClass = new SynClass();
        synClass.start();

        SleepTools.second(1);

    }

}
