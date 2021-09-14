package cn.enjoy.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class UseAtomicArray {

    static int[] value = new int[]{1, 2};

    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.set(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
