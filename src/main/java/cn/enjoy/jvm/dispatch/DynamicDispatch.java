package cn.enjoy.jvm.dispatch;

/**
 * 动态分派
 */
public class DynamicDispatch {

    static abstract class Human{
        protected abstract void sayHello();
    }

    static class Man extends Human{
        @Override
        protected void sayHello() {
            System.out.println("hello,man");
        }
    }

    static class WoMan extends Human{
        @Override
        protected void sayHello() {
            System.out.println("hello,WoMan");
        }
    }

    public static void main(String[] args) {
        Human h1 = new Man();
        Human h2 = new WoMan();

        h1.sayHello();
        h2.sayHello();
    }

}
