package cn.enjoy.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class UseAutomicInt {

    static AtomicInteger ai = new AtomicInteger(10);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.incrementAndGet());
        System.out.println(ai.get());
    }
}
