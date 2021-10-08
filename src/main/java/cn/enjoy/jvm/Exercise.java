package cn.enjoy.jvm;

/**
 * 根据字节码分析下下面结果为啥是false
 */
public class Exercise {

    static void print(Exercise e1, Exercise e2) {
        System.out.println(e1 == (e1 = e2));
    }

    public static void main(String[] args) {
        Exercise e1 = new Exercise();
        Exercise e2 = new Exercise();
        print(e1, e2);
    }

}
