package cn.enjoy.spring.cap8.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest8 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Cap8MainConfig.class);

        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        Bird bird = (Bird) ac.getBean("bird");
        System.out.println(bird);

        System.out.println("IOC容器创建完成.....");
    }

}
