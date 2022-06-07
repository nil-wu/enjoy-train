package cn.enjoy.thread.wait;

public class TestExpress {

    private static Express express = new Express(0, Express.CITY);

    private static class CheckKm extends Thread{

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getId()+" km线程启动");
            express.waitKm();
        }
    }

    private static class CheckSite extends Thread{

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getId()+" site线程启动");
            express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {//三个线程
            new CheckSite().start();
        }
        for (int i = 0; i < 3; i++) {
            new CheckKm().start();
        }
        Thread.sleep(1000);//保证上面6个线程都能启动起来

        //上面6个线程，其实在调用wait方法前，都是同时只是一个线程进入express对象的方法，说明Synchronized锁的是对象，而不是某个方法

        express.changeKm();//快递地点变化
//        express.changeSite();

    }

}
