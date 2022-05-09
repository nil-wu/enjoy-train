package cn.enjoy.thread.vola;

import cn.enjoy.thread.tools.SleepTools;

public class VolatileTest {

    private static class VolatileVar implements Runnable{

        private volatile int a = 0;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        @Override
        public void run() {

            String name = Thread.currentThread().getName();
            System.out.println(name + ":===============" + a);
            SleepTools.ms(3000);
//            a = 1;
            System.out.println(name + ":===============" + a);
        }
    }

    public static void main(String[] args) {
        VolatileVar v = new VolatileVar();

        Thread t1 = new Thread(v);
        Thread t2 = new Thread(v);

        t1.start();
        SleepTools.ms(1000);
        v.setA(2);
        t2.start();


    }
}
