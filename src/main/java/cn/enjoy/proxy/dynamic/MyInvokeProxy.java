package cn.enjoy.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvokeProxy implements InvocationHandler {
    private Object targe;

    public MyInvokeProxy() {
        super();
    }

    public MyInvokeProxy(Object targe) {
        super();
        this.targe = targe;
    }

    public Object bind(Object targe) {
        this.targe = targe;
        return getProxyInstance();
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(targe.getClass().getClassLoader(), targe.getClass().getInterfaces(), this);
    }

    private void doSomeThingBefore(){
        System.out.println("王美丽说的父母说：我得先调查下这个男孩子的背景！");
    }

    private void doSomeThingAfter(){
        System.out.println("王美丽的父母说：他有没有对你动手动脚啊？");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomeThingBefore();
        Object ret = method.invoke(targe, args);
        doSomeThingAfter();
        return ret;
    }
}
