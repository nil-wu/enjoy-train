package cn.enjoy.spring.cap7.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Train implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("Train ....destroy....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Train ....afterPropertiesSet....");
    }
}
