package cn.enjoy.proxy.dynamic;

import cn.enjoy.proxy.Girl;
import cn.enjoy.proxy.WangMeiLi;

public class Lison2 {

    public static void main(String[] args) {
        //第一种调用
        ((Girl) new MyInvokeProxy().bind(new WangMeiLi())).date();

        //第二种调用
        ((Girl)new MyInvokeProxy(new WangMeiLi()).getProxyInstance()).date();

    }
}
