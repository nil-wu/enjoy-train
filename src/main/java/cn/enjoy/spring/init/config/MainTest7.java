package cn.enjoy.spring.init.config;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

public class MainTest7 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Cap7MainConfig.class);

//        Object bean = ac.getBean("&cn.enjoy.spring.bean.JamesFactoryBean");
//        Object bean = ac.getBean("jamesImportSelect");

        System.out.println(StringUtils.hasLength("1"));


        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        ac.close();

    }
}
