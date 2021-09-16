package cn.enjoy.atomic;

import cn.enjoy.thread.tools.SleepTools;

import java.util.concurrent.atomic.AtomicStampedReference;

public class UseAtomicStampedReference {

    static AtomicStampedReference<String> asr = new AtomicStampedReference<String>("Mark", 0);

    public static void main(String[] args) throws Exception{

        final int oldStamp = asr.getStamp();
        final String oldReference = asr.getReference();

        System.out.println("原始数据：" + oldReference + "=======" + oldStamp);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(asr.getReference().hashCode());
                System.out.println(Thread.currentThread().getName()
                        + "当前变量值：" + asr.getReference() + " 当前版本：" + asr.getStamp() + "-" + asr.compareAndSet(oldReference, oldReference + "java", oldStamp, oldStamp + 1));
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(asr.getReference().hashCode());
                //此处 oldReference 还是原来的 oldReference ，oldReference的值永远不变，变的是 asr.getReference()
                System.out.println(Thread.currentThread().getName()
                        + "当前变量值：" + oldReference + " 当前版本：" + asr.getStamp() + "-" + asr.compareAndSet(oldReference, oldReference + "C", oldStamp, oldStamp + 1));
            }
        });

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();

        System.out.println(asr.getReference()+"================================================"+asr.getStamp());

        SleepTools.ms(1000);

    }
}
