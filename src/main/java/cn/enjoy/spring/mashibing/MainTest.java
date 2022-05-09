package cn.enjoy.spring.mashibing;

import cn.enjoy.spring.cap1.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person)ac.getBean("person");

        System.out.println(person);

    }

}
