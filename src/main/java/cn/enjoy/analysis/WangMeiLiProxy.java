package cn.enjoy.analysis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class WangMeiLiProxy implements InvocationHandler {

    private Girl gril;

    public WangMeiLiProxy(Girl gril) {
        super();
        this.gril = gril;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomeThingBefore();
        Object ret = method.invoke(gril, args);
        doSomeThingEnd();
        return ret;
    }

    public void doSomeThingBefore(){
        System.out.println("王美丽说的父母说：我得先调查下这个男孩子的背景");
    }

    public void doSomeThingEnd(){
        System.out.println("王美丽说的父母说：他有没有对你动手动脚啊");
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(gril.getClass().getClassLoader(), gril.getClass().getInterfaces(), this);
    }

}
