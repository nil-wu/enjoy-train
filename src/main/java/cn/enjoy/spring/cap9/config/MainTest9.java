package cn.enjoy.spring.cap9.config;

import cn.enjoy.spring.cap9.dao.TestDao;
import cn.enjoy.spring.cap9.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest9 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Cap9MainConfig.class);
        TestDao testDao = (TestDao)ac.getBean("testDao");
        TestService testService = (TestService)ac.getBean("testService");

        System.out.println(testDao == testService.getTestDao());
    }

}
