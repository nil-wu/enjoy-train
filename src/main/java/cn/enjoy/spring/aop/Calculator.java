package cn.enjoy.spring.aop;

public class Calculator {

    //业务逻辑方法
    public int div(int i, int j) {
        System.out.println("----------------");
        if(j == 0 ) return -1;
        return i/j;
    }
}
