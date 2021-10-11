package cn.enjoy.jvm.varargs;

public class VarArags {

    //可能很多 0~很多
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    //要求参数的个数，是1~很多个
    static int sum1(int... args) {
        if (args.length == 0) {
            //做点异常处理
        }
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

}
