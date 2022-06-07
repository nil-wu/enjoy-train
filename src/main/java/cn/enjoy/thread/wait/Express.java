package cn.enjoy.thread.wait;

public class Express {

    public final static String CITY = "ShangHai";
    public int km;
    private String site;

    public Express() {
        super();
    }

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public synchronized void changeKm(){
        this.km = 101;
        notifyAll();
    }

    public synchronized void changeSite(){
        this.site = "BeiJing";
        notifyAll();
    }

    public synchronized void waitKm(){
        System.out.println(Thread.currentThread().getId() + " waitKm获取锁");

        while (this.km <= 100) {
            try {
                System.out.println(Thread.currentThread().getId() + " 调用waitKm方法释放锁");
                wait();//此处释放锁（synchronized waitKm 是对象锁，同一对象只能有一个线程进来，但因为此处释放锁，所以wait后其他线程就可以进来了）
                System.out.println("check km thread[" + Thread.currentThread().getId() + "] 被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the km is " + this.km+",I will change db.");
    }

    public synchronized void waitSite(){
        System.out.println(Thread.currentThread().getId() + " waitSite获取锁");

        while (CITY.equals(this.site)) {
            try {
                System.out.println(Thread.currentThread().getId() + " 调用waitSite方法释放锁");
                wait();
                System.out.println("check site thread[" + Thread.currentThread().getId() + "] is be notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the site is " + this.km+",I will call user.");
    }

}
