package cn.enjoy.thread.dcl;

/**
 * 懒汉式-双重检查
 */
public class SingleDcl {

    private static SingleDcl singleDcl;

    public SingleDcl() {
    }

    public static SingleDcl getSingleDcl(){
        if (singleDcl == null) {
            synchronized (SingleDcl.class) { //类锁
                if (singleDcl == null) {
                    singleDcl = new SingleDcl();//构造方法不是一个原子操作
                }
            }
        }
        return singleDcl;
    }

}
