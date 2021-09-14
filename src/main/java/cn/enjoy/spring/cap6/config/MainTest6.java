package cn.enjoy.spring.cap6.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest6 {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Cap6MainConfig.class);

//        Object bean = ac.getBean("&cn.enjoy.spring.bean.JamesFactoryBean");
//        Object bean = ac.getBean("jamesImportSelect");

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

    }
}
