package cn.enjoy.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExpressCond {

    public final static String CITY = "ShangHai";
    public int km;
    private String site;
    private Lock kmLock = new ReentrantLock();
    private Lock siteLock = new ReentrantLock();
    private Condition kmCond = kmLock.newCondition();
    private Condition siteCond = siteLock.newCondition();

    public ExpressCond() {
        super();
    }

    public ExpressCond(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public synchronized void changeKm(){
        kmLock.lock();
        try {
            this.km = 101;
            kmCond.signalAll();
        }finally {
            kmLock.unlock();
        }
    }

    public synchronized void changeSite(){
        siteLock.lock();
        try {
            this.site = "BeiJing";
            siteCond.signalAll();
        }finally {
            siteLock.unlock();
        }
    }

    public synchronized void waitKm(){
        System.out.println(Thread.currentThread().getId() + " 获取锁");

        while (this.km <= 100) {
            try {
                System.out.println(Thread.currentThread().getId() + " 调用wait方法释放锁");
                wait();//此处释放锁（synchronized waitKm 是对象锁，同一对象只能有一个线程进来，但因为此处释放锁，所以wait后其他线程就可以进来了）
                System.out.println("check km thread[" + Thread.currentThread().getId() + "] 被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the km is " + this.km+",I will change db.");
    }

    public synchronized void waitSite(){
        while (CITY.equals(this.site)) {
            try {
                wait();
                System.out.println("check site thread[" + Thread.currentThread().getId() + "] is be notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the site is " + this.km+",I will call user.");
    }

}
