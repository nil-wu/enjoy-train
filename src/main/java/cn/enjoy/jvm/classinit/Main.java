package cn.enjoy.jvm.classinit;

public class Main {

    public static void main(String[] args) {
//        System.out.println(SubClazz.value);//对于静态字段而言，只有直接定义了这个字段的类才会被初始化。（即便通过子类调用了父类的静态字段，此时只会初始化父类，不会初始化子类）
//        SuperClazz[] sca = new SuperClazz[10];//声明数组的情况，不会触发类的初始化
//        System.out.println(SubClazz.HELLOWORLD);//编译阶段的常量传播优化，不会初始化父类和子类
        System.out.println(SubClazz.WHAT);//因为valust是第一种情况，所以按第一种情况走
    }
    

}
