package cn.enjoy.jvm.classinit;

public class SubClazz extends SuperClazz{
    static {
        System.out.println("SubClazz init!");
    }
}
