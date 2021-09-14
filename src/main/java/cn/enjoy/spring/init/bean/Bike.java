package cn.enjoy.spring.init.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bike implements InitializingBean, DisposableBean {

    public Bike() {
        System.out.println("construct");
    }

    public void myInit(){
        System.out.println("myInit");
    }

    public void myDestroy(){
        System.out.println("myDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @PostConstruct
    public void jsr250Init(){
        System.out.println("jsr250Init");
    }

    @PreDestroy
    public void jsr250destroy(){
        System.out.println("jsr250destroy");
    }


}
