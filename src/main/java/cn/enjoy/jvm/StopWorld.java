package cn.enjoy.jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * vm arguments:
 * -Xmx300M -Xms300M -XX:+UseSerialGC -XX:PrintGCDetails
 */
public class StopWorld {

    public static class FillListThread extends Thread{
        List<byte[]> list = new LinkedList<>();

        @Override
        public void run(){
            try {
                while (true) {
                    if (list.size() * 512 / 1024 / 1024 >= 990) {
                        list.clear();
                        System.out.println("list is clear");
                    }
                    byte[] bl;
                    for (int i = 0; i < 100; i++) {
                        bl = new byte[512];
                        list.add(bl);
                    }
                    Thread.sleep(1);
                }
            } catch (Exception e) {

            }
        }
    }

    /*每100ms定时打印*/
    public static class TimerThread extends Thread{
        public final static long startTime = System.currentTimeMillis();

        @Override
        public void run(){
            try {
                while (true) {
                    long t = System.currentTimeMillis() - startTime;
                    System.out.println(t / 1000 + "." + t % 1000);
                    Thread.sleep(100);
                }
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        FillListThread myThread = new FillListThread();
        TimerThread timerThread = new TimerThread();
        myThread.start();
        timerThread.start();
    }

}
