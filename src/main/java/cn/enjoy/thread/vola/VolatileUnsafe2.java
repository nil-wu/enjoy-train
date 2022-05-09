package cn.enjoy.thread.vola;

import cn.enjoy.thread.tools.SleepTools;

import java.util.Random;

public class VolatileUnsafe2 {

    private static class VolatileVar implements Runnable{

        private volatile int a = 0;

        @Override
        public void run() {

            String name = Thread.currentThread().getName();
//            a = a + 1;

            System.out.println(name + ":===============" + a);
            Random random = new Random();
            int i = random.nextInt(100);
            SleepTools.ms(i);

            a = Integer.valueOf(String.valueOf(i));
            System.out.println(name + ":===============" + a + "新的随机数：" + i);
        }
    }

    public static void main(String[] args) {
        VolatileVar v = new VolatileVar();

        Thread t1 = new Thread(v);
        SleepTools.ms(100);
        Thread t2 = new Thread(v);
        SleepTools.ms(100);
        Thread t3 = new Thread(v);
        SleepTools.ms(100);
        Thread t4 = new Thread(v);
        SleepTools.ms(100);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
