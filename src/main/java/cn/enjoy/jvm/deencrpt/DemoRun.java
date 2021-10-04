package cn.enjoy.jvm.deencrpt;

public class DemoRun {
    public static void main(String[] args) throws Exception{
        CustomClassLoader demoCustomClassLoader = new CustomClassLoader("My ClassLoader");
        demoCustomClassLoader.setBasePath("");
        Class<?> clazz = demoCustomClassLoader.findClass("");
        System.out.println(clazz.getClassLoader());
        Object o = clazz.newInstance();
        System.out.println(o);
    }
}
