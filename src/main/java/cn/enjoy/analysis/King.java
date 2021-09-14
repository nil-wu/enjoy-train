package cn.enjoy.analysis;

public class King {

    public static void main(String[] args) {
        Girl girl = new WangMeiLi();

        WangMeiLiProxy family = new WangMeiLiProxy(girl);
        Girl mother = (Girl)family.getProxyInstance();
        mother.date();

    }
}
