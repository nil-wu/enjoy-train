package cn.enjoy.pool;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class DBPoolTest {
    static DBPool pool = new DBPool(10);
    //控制器：控制main线程将会等待所有Worker结束后才能继续执行
    static CountDownLatch end;

    /**
     * AtomicInteger 理解为线程安全的计数器
     * CountDownLatch 闭锁
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        int threadCount = 50;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();//计数器，统计可以拿到的线程
        AtomicInteger notGot = new AtomicInteger();//计数器，统计没有拿到连接的线程

        for (int i = 0; i < threadCount ; i++) {
            Thread thread = new Thread(new Worker(count, got, notGot), "worker_" + i);
            thread.start();
        }

        end.await();//main 线程在此处等待

        System.out.println("总共尝试了：" + (threadCount * count) );
        System.out.println("拿到连接的次数： " + got);
        System.out.println("没能拿到连接的次数： " + notGot);
    }

    static class Worker implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public Worker(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        public void run(){
            while (count > 0) {
                try {
                    Connection connection = pool.fetchConn(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConn(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() + "等待超时!");
                    }
                } catch (Exception ex) {

                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
