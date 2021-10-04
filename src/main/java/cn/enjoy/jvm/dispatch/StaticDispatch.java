package cn.enjoy.jvm.dispatch;

/**
 * 静态分派
 */
public class StaticDispatch {

    static abstract class Human{}//静态类型
    static class Man extends Human{}//变量的实际类型
    static class Woman extends Human{}//变量的实际类型

    //虚拟机在实现方法重载的时候，是根据变量的静态类型来决定的
    //方法重载
    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    //方法重载
    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    //方法重载
    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human h1 = new Man();
        Human h2 = new Woman();

        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(h1);
        sr.sayHello(h2);

    }

}
