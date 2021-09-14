package cn.enjoy.spring.aop.config;


import cn.enjoy.spring.aop.Calculator;
import cn.enjoy.spring.init.config.Cap7MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

public class MainTest10 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Cap10MainConfig.class);

//        Object bean = ac.getBean("&cn.enjoy.spring.bean.JamesFactoryBean");
        Calculator c = (Calculator)ac.getBean("calculator");
        int div = c.div(4, 3);
        System.out.println(div);
        ac.close();

    }
}
