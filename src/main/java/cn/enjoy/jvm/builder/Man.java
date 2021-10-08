package cn.enjoy.jvm.builder;

public class Man extends Person {
    public Man(){
        System.out.println("create a man");
    }

    @Override
    public String toString() {
        return "Man{}";
    }
}
