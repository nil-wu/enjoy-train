package cn.enjoy.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class HalfAutomicInt {

    private AtomicInteger ai = new AtomicInteger();

    public void increment(){
        for (; ; ) {
            int i = ai.get();
            boolean b = ai.compareAndSet(i, i++);
            if (b) {
                break;
            }
        }
    }
}
