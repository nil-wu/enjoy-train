package cn.enjoy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class WangMeiLiProxy implements InvocationHandler {

    private Girl girl;

    public WangMeiLiProxy() {
        super();
    }

    public WangMeiLiProxy(Girl girl) {
        super();
        this.girl = girl;
    }

    public Object bind(Girl girl) {
        this.girl = girl;
        return getProxyInstance();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomeThingBefore();
        Object ret = method.invoke(girl, args);
        doSomeThingAfter();
        return ret;
    }

    private void doSomeThingBefore(){
        System.out.println("王美丽说的父母说：我得先调查下这个男孩子的背景！");
    }

    private void doSomeThingAfter(){
        System.out.println("王美丽的父母说：他有没有对你动手动脚啊？");
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(girl.getClass().getClassLoader(), girl.getClass().getInterfaces(), this);
    }
}
