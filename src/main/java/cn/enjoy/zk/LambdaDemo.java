package cn.enjoy.zk;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        }).start();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        };

        //lambda 简化匿名委托（匿名内部类）
        Runnable r2 = ()->{
            System.out.println("123");
        };

        //再举一个例子
        Comparable<Integer> c1 = new Comparable<Integer>() {
            @Override
            public int compareTo(Integer o) {
                return 0;
            }
        };

        //lambda
        Comparable<Integer> c2 = (Integer o)->{
            return 0;
        };

        //还可以再简化
        Comparable<Integer> c3 = o -> 0;

        //lambda需要函数接口,只有一个方法  @FunctionalInterface

        //stream api 里面方法参数都是函数接口，可以用lambda表达式简化
        List list = new ArrayList();
//        list.stream().forEach();

        //lambda 对匿名委托的简化
        //方法引用 对lambda的进一步简化

    }
}
