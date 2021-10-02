package cn.enjoy.jvm.classinit;

public class SuperClazz {

    static {
        System.out.println("SuperClazz init!");
    }

    public static int value = 123;
    public static final String HELLOWORLD = "hello,world";
    public static final int WHAT = value;

}
