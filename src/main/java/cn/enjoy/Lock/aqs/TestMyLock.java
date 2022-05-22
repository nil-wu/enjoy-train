package cn.enjoy.Lock.aqs;

import cn.enjoy.thread.tools.SleepTools;
import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMyLock {

    public void test(){
        final Lock lock = new ReentrantLock();
//        final Lock lock = new SelfLock();

        class Worker extends Thread{
            public void run(){
                while (true){
                    lock.lock();
                    try {
                        SleepTools.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepTools.second(1);
                    }finally {
                        lock.unlock();
                    }
                    SleepTools.second(2);
                }
            }
        }

        //启动10个子线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        //主线程每隔一秒换行
        for (int i = 0; i < 10; i++) {
            SleepTools.second(1);
            System.out.println();
        }

    }

    public static void main(String[] args) {
        TestMyLock testMyLock = new TestMyLock();
        testMyLock.test();

    }

}
