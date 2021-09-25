package cn.enjoy.jvm;

public class UseStack {

    public static void main(String[] args) {
        Stack stack = new Stack();
        Object o = new Object();
        System.out.println("0=" + o);
        stack.push(o);
        Object o1 = stack.pop();
        System.out.println("o1=" + o1);
    }

}
