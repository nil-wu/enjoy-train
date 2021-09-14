package cn.enjoy.proxy;

public class Lison {

    public static void main(String[] args) {
//        Girl girl = new WangMeiLi();
//        WangMeiLiProxy family = new WangMeiLiProxy(girl);
//        Girl mother = (Girl)family.getProxyInstance();
//        mother.date();

        //非动态代理
//        new WangMeiLi().date();
        //使用了动态代理
        getProxy(new WangMeiLi()).date();

    }

    private static Girl getProxy(Girl girl){
//        return (Girl)new WangMeiLiProxy(girl).getProxyInstance();
        return (Girl)new WangMeiLiProxy().bind(girl);
    }

}
